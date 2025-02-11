import employees.Employee;
import factory.EmployeeFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lib.SafeInput;

public class Main {

  public static void main(String[] var0) {

    List<Employee> employees = new ArrayList<>();

    List<String> roles = Arrays.asList(
        "Manager",

        "Frontend Developer",
        "Backend Developer",
        "DevOps Developer",
        "Quality Assurance",
        "UI/UX Designer",

        "Marketing Specialist"
    );

    for (String role : roles) {
      System.out.println("-----------------------------");
      System.out.println("# " + role);

      // 1. 직군별 각 사람에 대한 첫 스펙 및 능력을 입력 받기
      Employee employee = EmployeeFactory.createEmployee(role);
      employees.add(employee);
    }

    // 2. 총 연봉 계산
    int totalSalary = 0;
    for (Employee employee : employees) {
      totalSalary += employee.getSalary();
    }
    System.out.println("총 연봉 합계: " + totalSalary + "만원");

    // 3. 변경하고 싶은 직원 번호 입력받아서 수정하기
    while (true) {
      for (int i = 0; i < roles.size(); i++) {
        System.out.println((i + 1) + ". " + roles.get(i) + ": " + employees.get(i).getSalary());
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
      Employee selectedEmployee = employees.get(select - 1);
      System.out.println("선택한 직군: " + roles.get(select - 1));

      totalSalary -= selectedEmployee.getSalary();
      int newSalary = reselectSalary(selectedEmployee); // 연봉 재선택 로직
      totalSalary += newSalary;

      selectedEmployee.setSalary(newSalary);
      System.out.println("연봉이 업데이트되었습니다.");
    }
    System.out.println("최종 비용: ");
    for (int i = 0; i < roles.size(); i++) {
      System.out.println((i + 1) + ". " + roles.get(i) + ": " + employees.get(i).getSalary());
    }

    System.out.println(totalSalary + "만원");
    System.out.println("행운을 빌어요!");

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
