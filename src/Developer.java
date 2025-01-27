import java.util.Arrays;
import java.util.List;

// Developer 그룹
public class Developer extends Employee {
    private static final List<Integer> salaryList = Arrays.asList(3000, 4000, 4500, 5000, 6000);

    public Developer(String name, int salary, int experience) {
        super(name, salary, experience);
    }

    @Override
    public String getRole() {
        return "Developer";
    }

    @Override
    public List<Integer> getSalaryList() {
        return salaryList;
    }
}
