package employees.web;

import employees.Employee;
import java.util.List;

public abstract class Developer extends Employee {

  private String domain;
  private int communationLevel;
  private List<String> stacks;

  public Developer(int salary, int experienceYears, String domain,
      int communationLevel,
      List<String> stacks) {
    super(salary, experienceYears);
    this.domain = domain;
    this.communationLevel = communationLevel;
    this.stacks = stacks;
  }

  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public int getCommunationLevel() {
    return communationLevel;
  }

  public void setCommunationLevel(int communationLevel) {
    this.communationLevel = communationLevel;
  }

  public List<String> getStacks() {
    return stacks;
  }

  public void setStacks(List<String> stacks) {
    this.stacks = stacks;
  }
}
