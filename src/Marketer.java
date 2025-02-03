import java.util.Arrays;
import java.util.List;

public class Marketer extends Employee {
    private static final List<Integer> salaryList = Arrays.asList(3000, 4000, 4500, 5000, 6000);

    public Marketer(String role) {
        super(role);
        this.setSalaryList(salaryList);
    }

    @Override
    public String getInfo() {
        return "연봉" + " " + this.getSalary() + " "+ this.getRole() + ": 최선을 다하겠습니다";
    }
}