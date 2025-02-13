package lib.Threads;

import data.CompanyData;
import employees.Employee;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lib.TimeTracker;

public class ResignationThread extends Thread {

  private final CompanyData companyData;
  private final TimeTracker timeTracker;

  public ResignationThread(CompanyData companyData, TimeTracker timeTracker) {
    this.companyData = companyData;
    this.timeTracker = timeTracker;
  }

  @Override
  public void run() {
    try {
      while (timeTracker.isRunning()) {
        Thread.sleep(1000); // 1초마다 체크

        // ✅ 미지급 직원 수가 15명을 초과하면 퇴사 처리
        if (companyData.getUnpaidQueueSize() >= 15) {
          Employee resignationEmployee = resignProcess();
        }
      }
    } catch (InterruptedException e) {
      System.out.println("⏹ 퇴사 스레드 종료");
    }
  }

  private Employee resignProcess() {
    List<Employee> unpaidList = new ArrayList<>(companyData.getUnpaidEmployees());

    // 1️⃣ 미지급 급여가 가장 많은 직원 찾기
    unpaidList.sort(Comparator.comparing(Employee::getSalary).reversed());
    int maxUnpaidSalary = unpaidList.get(0).getSalary();

    List<Employee> topUnpaidEmployees = new ArrayList<>();
    for (Employee emp : unpaidList) {
      if (emp.getSalary() == maxUnpaidSalary) {
        topUnpaidEmployees.add(emp);
      }
    }

    // 1️⃣-1️⃣ 만약 미지급 급여가 가장 많은 직원이 1명이라면 즉시 퇴사
    if (topUnpaidEmployees.size() == 1) {
      return resignEmployee(topUnpaidEmployees.get(0));
    }

    // 2️⃣ 미지급 급여가 같은 직원이 여러 명이면, 경력이 가장 많은 직원 찾기
    topUnpaidEmployees.sort(Comparator.comparing(Employee::getExperienceYears).reversed());
    int maxExperience = topUnpaidEmployees.get(0).getExperienceYears();

    List<Employee> topExperienceEmployees = new ArrayList<>();
    for (Employee emp : topUnpaidEmployees) {
      if (emp.getExperienceYears() == maxExperience) {
        topExperienceEmployees.add(emp);
      }
    }

    // 2️⃣-1️⃣ 만약 경력이 가장 많은 직원이 1명이라면 즉시 퇴사
    if (topExperienceEmployees.size() == 1) {
      return resignEmployee(topExperienceEmployees.get(0));
    }

    // 3️⃣ 미지급 급여와 경력까지 같은 직원이 여러 명이면, unpaidQueue에서 가장 오래된 직원 퇴사
    Employee oldestUnpaidEmployee = companyData.pollUnpaidQueue();
    return resignEmployee(oldestUnpaidEmployee);
  }

  // 실제로 직원 퇴사 처리
  private Employee resignEmployee(Employee employee) {
    companyData.removeEmployee(employee);
    companyData.removeFromUnpaidQueue(employee);
    System.out.println("❌ " + employee.getRole() + "이(가) 퇴사했습니다! (미지급: " + employee.getSalary() + "원, 경력: " + employee.getExperienceYears() + "년)\n");
    return employee;
  }


}
