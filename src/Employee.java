import java.util.List;

// 공통 상위 클래스
public abstract class Employee {
    private String name;
    private List<Integer> salaryList;
    private int salary;
    private int experience; // 경력(연수)

    // 생성자
    public Employee(String name, int salary, int experience) {
        this.name = name;
        this.salary = salary;
        this.experience = experience;
    }

    // 공통 메서드
    public String getName() {
        return name;
    }
    public int getSalary() {
        return salary;
    }
    public int getExperience() {
        return experience;
    }

    public abstract String getRole(); // 역할 정보 (추상 메서드)
    public abstract List<Integer> getSalaryList(); // 연봉 리스트 반환 (추상 메서드)
}


