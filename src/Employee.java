import java.util.List;

// 공통 상위 클래스
public abstract class Employee {
    private int salary;
    private List<Integer> salaryList;

    private String role;

    public Employee(String role) {
        this.setRole(role);
    }
    // 공통 메서드
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Integer> getSalaryList() {
        return this.salaryList;
    }
    public void setSalaryList(List<Integer> salaryList) {
        this.salaryList = salaryList;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    // 추상 메소드
    public abstract String getInfo ();


}


