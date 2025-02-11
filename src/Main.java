import employees.Employee;
import factory.EmployeeFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

  private static final Scanner sc = new Scanner(System.in);

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

        /*
        로직
        1. 직군별 각 사람에 대한 첫 스펙 및 능력을 입력 받기
        2. 총 연봉 계산
        3. 변경하고 싶은 직원 번호 입력받아서 수정하기
        4. 수정하다가 -1 입력시 마무리
        * */

    for (String role : roles) {
      System.out.println("-----------------------------");
      System.out.println("# " + role);

      // 1. 직군별 각 사람에 대한 첫 스펙 및 능력을 입력 받기
      Employee employee = EmployeeFactory.createEmployee(role, sc);
      employees.add(employee);
    }

    // 2. 총 연봉 계산
    int totalSalary = 0;
    for (Employee employee : employees) {
      totalSalary += employee.getSalary();
    }
    System.out.println("총 연봉 합계: " + totalSalary + "만원");

    // 3. 변경하고 싶은 직원 번호 입력받아서 수정하기
    System.out.println("재선택하고 싶은 직군의 번호를 입력해주세요. 없으면 -1을 입력하세요.");
    while (true) {
      for (int i = 0; i < roles.size(); i++) {
        System.out.println((i + 1) + ". " + roles.get(i) + ": " + employees.get(i).getSalary());
      }

      int select = sc.nextInt();
      if (select == -1) {
        break;
      }

      if (1 <= select && select <= roles.size()) {
        Employee selectedEmployee = employees.get(select - 1);
        System.out.println("선택한 직군: " + roles.get(select - 1));

        totalSalary -= selectedEmployee.getSalary();
        int newSalary = reselectSalary(selectedEmployee); // 연봉 선택 로직 호출
        totalSalary += newSalary;

        selectedEmployee.setSalary(newSalary);
        System.out.println("연봉이 업데이트되었습니다.");
      } else {
        System.out.println("유효하지 않은 번호입니다. 다시 선택하세요.");
      }
    }
    System.out.println("최종 비용: ");
    for (int i = 0; i < roles.size(); i++) {
      System.out.println((i + 1) + ". " + roles.get(i) + ": " + employees.get(i).getSalary());
    }

    System.out.println(totalSalary + "만원");
    System.out.println("행운을 빌어요!");

    sc.close();
  }

  // 연봉 선택 로직
  private static int reselectSalary(Employee employee) {
    int salary;
    while (true) {
      System.out.print("연봉을 입력하세요: ");
      salary = sc.nextInt();
      if (salary != employee.getSalary()) {
        break; // 유효한 값이면 루프 종료
      }
      System.out.println("같은 연봉입니다. 다시 입력하세요.");
    }
    return salary;
  }
}
