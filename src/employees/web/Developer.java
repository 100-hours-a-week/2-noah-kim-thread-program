package employees.web;

import employees.Employee;
import java.util.List;

public abstract class Developer extends Employee {

  private String domain;
  private int communicationLevel;
  private List<String> stacks;

  public Developer(int salary, int experienceYears, String domain,
      int communicationLevel,
      List<String> stacks) {
    super(salary, experienceYears);
    this.domain  = domain;
    this.communicationLevel = communicationLevel;
    this.stacks = stacks;
  }

  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public int getCommunicationLevel() {
    return communicationLevel;
  }

  public void setCommunicationLevel(int communicationLevel) {
    this.communicationLevel = communicationLevel;
  }

  public List<String> getStacks() {
    return stacks;
  }

  public void setStacks(List<String> stacks) {
    this.stacks = stacks;
  }
}
