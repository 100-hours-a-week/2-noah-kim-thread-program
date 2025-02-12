package lib.Salary;

import data.CompanyData;
import employees.Employee;
import java.util.List;

public class SalaryThread extends Thread {
  private final CompanyData companyData;
  private boolean running = true;

  // 생성자
  public SalaryThread(CompanyData companyData) {
    this.companyData = companyData;
  }

  public void stopThread() {
    running = false;
  }

  @Override
  public void run() {
    try {
      while (running) {
        synchronized (companyData) {
          companyData.wait(); // `TimeThread`에서 신호를 받을 때까지 대기
        }

        System.out.println("💰 [임금 지급 시작] 이번 달 분배금: " + companyData.Fund + "원");

        List<Employee> sortedEmployees = companyData.getUnpaidEmployees();
        int remainingFund = companyData.Fund;
        for (Employee emp : sortedEmployees) {
          if (remainingFund >= emp.getSalary()) {
            remainingFund -= emp.getSalary();
            System.out.println("✅ " + emp.getRole() + "에게 " + emp.getSalary() + "원 지급 완료!");
          }
          else {
            System.out.println("🚨 예산 부족! " + emp.getRole() + " 임금 지급 대기!");
            companyData.addToUnpaidQueue(emp);
          }
        }

        Thread.sleep(5000);
      }
    } catch (InterruptedException e) {
      System.out.println("⏹ 임금 지급 스레드 종료");
    }
  }
}

