import java.util.Arrays;
import java.util.List;

public class Developer extends Employee {
    private static final List<Integer> salaryList = Arrays.asList(3000, 4000, 4500, 5000, 6000);

    public Developer(String role) {
        super(role);
        this.setSalaryList(salaryList);
    }


    @Override
    public String getInfo() {
        return "연봉" + " " + this.getSalary() + " "+ this.getRole() + ": 열심히 공부하겠습니다";
    }
}
