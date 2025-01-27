import java.util.Arrays;
import java.util.List;

public class Marketer extends Employee {
    private static final List<Integer> salaryList = Arrays.asList(3000, 4000, 4500, 5000, 6000);


    @Override
    public List<Integer> getSalaryList() {
        return salaryList;
    }
}
