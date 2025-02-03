import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] var0) {
        Scanner sc = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();
        List<String> roles = Arrays.asList(
                "Product Manager",
                "Frontend Developer",
                "Backend Developer",
                "Data Scientist",
                "Marketing",
                "UI/UX Designer",
                "DevOps Engineer",
                "Finance Manager"
        );

        // 직군별로 처리
        int salary;
        for (String role : roles) {
            System.out.println("-----------------------------");
            System.out.println("# " + role);

            Employee employee = createEmployee(role);
            salary = chooseSalary(sc, employee); // 연봉 선택 로직 호출
            employee.setSalary(salary);
            employees.add(employee);
        }

        // 총 연봉 계산
        int totalSalary = 0;
        for(Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        System.out.println("총 연봉 합계: " + totalSalary);

        // 재선택 루프
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
                salary = chooseSalary(sc, selectedEmployee); // 연봉 선택 로직 호출
                totalSalary += salary;

                selectedEmployee.setSalary(salary);
                System.out.println("연봉이 업데이트되었습니다.");
            } else {
                System.out.println("유효하지 않은 번호입니다. 다시 선택하세요.");
            }
        }
        System.out.println("최종 비용");
        for (int i = 0; i < roles.size(); i++) {
            System.out.println((i + 1) + ". " + roles.get(i) + ": " + employees.get(i).getSalary());
        }
        spaekAllResolutions(employees);

        System.out.println("필요한 총 비용: " + totalSalary);


        System.out.println("행운을 빌어요!");


    }

    // 역할에 따라 객체를 생성하는 메서드
    private static Employee createEmployee(String role) {
        switch (role) {
            case "Product Manager":
            case "Finance Manager":
                return new Manager(role);
            case "Frontend Developer":
            case "Backend Developer":
            case "Data Scientist":
            case "DevOps Engineer":
                return new Developer(role);
            case "Marketing":
                return new Marketer(role);
            case "UI/UX Designer":
                return new Designer(role);
            default:
                throw new IllegalArgumentException("Unknown role: " + role);
        }
    }

    // 연봉 선택 로직
    private static int chooseSalary(Scanner sc, Employee employee) {
        List<Integer> salaryList = employee.getSalaryList();
        System.out.print("연봉 선택지: ");
        System.out.println(Arrays.toString(salaryList.toArray()));

        int salary;
        while (true) {
            System.out.print("연봉을 선택하세요: ");
            salary = sc.nextInt();
            if (salaryList.contains(salary)) {
                break; // 유효한 값이면 루프 종료
            } else {
                System.out.println("유효하지 않은 연봉입니다. 다시 입력하세요.");
            }
        }
        return salary;
    }

    private static void spaekAllResolutions(List<Employee> Employees) {
        for(Employee employee : Employees) {
            System.out.println(employee.getInfo());
        }
    }
}
