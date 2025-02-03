import java.util.Arrays;
import java.util.List;

public class Manager extends Employee {
    private static final List<Integer> salaryList = Arrays.asList(3000, 4000, 4500, 5000, 6000);

    public Manager(String role) {
        super(role);
        this.setSalaryList(salaryList);
    }
    @Override
    public String getInfo() {
        return "연봉" + " " + this.getSalary() + " "+ this.getRole() + ": 사람, 프로젝트 관리 철저히 하겠습니다";
    }
}
