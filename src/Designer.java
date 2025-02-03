import java.util.Arrays;
import java.util.List;

public class Designer extends Employee {
    private static final List<Integer> salaryList = Arrays.asList(3000, 4000, 4500, 5000, 6000);

    public Designer(String role) {
        super(role);
        this.setSalaryList(salaryList);
    }


    @Override
    public String getInfo() {
        return "연봉" + " " + this.getSalary() + " "+ this.getRole() + ": 이쁘게 만들어보겠습니다~!";
    }
}
