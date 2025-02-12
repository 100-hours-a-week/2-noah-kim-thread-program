import data.CompanyData;
import employees.Employee;
import factory.EmployeeFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lib.SafeInput;
import lib.Timer.BillingSystem;
import lib.Timer.TimeTracker;
import lib.Timer.TimerThread;

public class Main {

  public static void main(String[] var0) {

    CompanyData companyData = new CompanyData();

    List<String> roles = Arrays.asList(
        "Manager",
        "Frontend Developer",
        "Backend Developer",
        "DevOps Developer",
        "Quality Assurance",
        "UI/UX Designer",
        "Marketing Specialist"
    );

    TimeTracker timeTracker = new TimeTracker();
    TimerThread timer  = new TimerThread(timeTracker);

    timer.start();
    for (String role : roles) {
      System.out.println("-----------------------------");
      System.out.println("# " + role);

      // 1. 직군별 각 사람에 대한 첫 스펙 및 능력을 입력 받기
      Employee employee = EmployeeFactory.createEmployee(role);
      companyData.addEmployee(employee);
      System.out.println(timeTracker.getElapsedTimeString() + "사용했습니다");
    }

    // 2. 총 연봉 계산
    System.out.println("총 연봉 합계: " + companyData.getSumSalary() + "만원");

    // 3. 변경하고 싶은 직원 번호 입력받아서 수정하기
    while (true) {
      for (int i = 0; i < roles.size(); i++) {
        System.out.println((i + 1) + ". " + roles.get(i) + ": " + companyData.getEmployees().get(i).getSalary());
      }

      int select = SafeInput.getValidInteger("재선택하고 싶은 직군의 번호를 입력해주세요. 없으면 -1을 입력하세요.");

      // 종료 조건
      if (select == -1) {
        timeTracker.stopTracking();
        break;
      }
      // 범위 벗어남
      if (select < 1 || select > roles.size()) {
        System.out.println("유효하지 않은 번호입니다. 다시 선택하세요.");
        continue;
      }
      Employee selectedEmployee = companyData.getEmployees().get(select - 1);
      System.out.println("선택한 직군: " + roles.get(select - 1));

      int newSalary = reselectSalary(selectedEmployee); // 연봉 재선택 로직
      selectedEmployee.setSalary(newSalary);

      System.out.println("연봉이 업데이트되었습니다.");
    }
    System.out.println("최종 비용: ");
    for (int i = 0; i < roles.size(); i++) {
      System.out.println((i + 1) + ". " + roles.get(i) + ": " + companyData.getEmployees().get(i).getSalary());
    }

    System.out.println(companyData.getSumSalary() + "만원");
    System.out.println("행운을 빌어요!");

    System.out.println("-------------프로그램 사용 비용----------------");
    System.out.println(BillingSystem.calculateFee(timeTracker.getElapsedTime()) + "원 사용했습니다. 계좌로 송금바랍니다");



    SafeInput.closeScanner();
  }

  // 연봉 선택 로직
  private static int reselectSalary(Employee employee) {
    int salary;
    while (true) {
      salary = SafeInput.getValidInteger("연봉을 입력하세요: ");
      if (salary == employee.getSalary()) {
        System.out.println("같은 연봉입니다. 다시 입력하세요.");
        continue;
      }
      break;
    }
    return salary;
  }
}
