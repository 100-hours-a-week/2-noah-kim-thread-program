import data.CompanyData;
import employees.Employee;
import employees.Role;
import factory.EmployeeFactory;
import java.util.Arrays;
import java.util.List;
import lib.SafeInput;
import lib.Threads.ResignationThread;
import lib.Threads.SalaryPaymentThread;
import lib.TimeTracker;
import lib.Threads.TimerThread;

public class Main {

  public static void main(String[] var0) {

    CompanyData companyData = new CompanyData();

    List<Role> roles = Arrays.asList(Role.values());
    for (Role role : roles) {
      System.out.println("-----------------------------");
      System.out.println("# " + role);

      // 1. 직군별 각 사람에 대한 첫 스펙 및 능력을 입력 받기
      Employee employee = EmployeeFactory.createEmployee(role);
      companyData.addEmployee(employee);
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
        break;
      }
      // 범위 벗어남
      if (select < 1 || select > roles.size()) {
        System.out.println("유효하지 않은 번호입니다. 다시 선택하세요.");
        continue;
      }
      System.out.println("선택한 직군: " + roles.get(select - 1));

      Employee selectedEmployee = companyData.getEmployees().get(select - 1);
      selectedEmployee.reselectSalary();

      System.out.println("연봉이 업데이트되었습니다.");
    }
    System.out.println("최종 비용: ");
    for (int i = 0; i < roles.size(); i++) {
      System.out.println((i + 1) + ". " + roles.get(i) + ": " + companyData.getEmployees().get(i).getSalary());
    }
    // ✅ 임금 지급 스레드 시작
    TimeTracker timeTracker = new TimeTracker();

    TimerThread timer  = new TimerThread(timeTracker);
    SalaryPaymentThread salaryPaymentThread = new SalaryPaymentThread(companyData, timeTracker);
    ResignationThread resignationThread = new ResignationThread(companyData, timeTracker);

    timer.start();
    salaryPaymentThread.start();
    resignationThread.start();

    System.out.println(companyData.getSumSalary() + "만원");
    System.out.println("행운을 빌어요!");

    // ✅ 종료 처리
    System.out.println("\n🛑 프로그램 종료를 원하면 Enter 키를 누르세요.");
    SafeInput.getValidString("");

    timeTracker.stopTracking();
    SafeInput.closeScanner();

    System.out.println("🔚 프로그램 종료");
  }


}
