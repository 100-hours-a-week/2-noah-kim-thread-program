package week1.assignment;

import java.util.Arrays;
import java.util.List;

// Manager 그룹
public class Manager extends Employee {
    private static final List<Integer> salaryList = Arrays.asList(3000, 4000, 4500, 5000, 6000);

    public Manager(String name, int salary, int experience) {
        super(name, salary, experience);
    }

    @Override
    public String getRole() {
        return "Manager";
    }

    @Override
    public List<Integer> getSalaryList() {
        return salaryList;
    }
}
