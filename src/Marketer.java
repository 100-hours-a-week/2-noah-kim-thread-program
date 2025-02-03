import java.util.Arrays;
import java.util.List;

public class Marketer extends Employee {
    private static final List<Integer> salaryList = Arrays.asList(3000, 4000, 4500, 5000, 6000);

    public Marketer() {
        this.setSalaryList(salaryList);
    }

    @Override
    public String getResolution() {
        return "연봉 " + this.getSalary() + " 마케터"+ " 열심히 하겠습니다!";
    }
}