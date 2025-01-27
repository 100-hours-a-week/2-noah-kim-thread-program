import java.util.List;

// 공통 상위 클래스
public abstract class Employee {
    private String name;
    private List<Integer> salaryList;



    private int salary;

    // 공통 메서드
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }
    public int getSalary() {
        return salary;
    }

    // 추상 메서드
    public abstract List<Integer> getSalaryList(); // 연봉 리스트 반환 (추상 메서드)
}


