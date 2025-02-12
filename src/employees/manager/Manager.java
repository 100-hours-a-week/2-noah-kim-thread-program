package employees.manager;

import employees.Employee;

public class Manager extends Employee {

  private final String role = "Manager";

  String domain;
  int leadershipLevel;
  int decisionMakingLevel;

  public Manager(int salary, int experienceYears, String domain, int leadershipLevel,
      int decisionMakingLevel) {
    super(salary, experienceYears);
    this.domain = domain;
    this.leadershipLevel = leadershipLevel;
    this.decisionMakingLevel = decisionMakingLevel;
  }

  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public int getLeadershipLevel() {
    return leadershipLevel;
  }

  public void setLeadershipLevel(int leadershipLevel) {
    this.leadershipLevel = leadershipLevel;
  }

  public int getDecisionMakingLevel() {
    return decisionMakingLevel;
  }

  public void setDecisionMakingLevel(int decisionMakingLevel) {
    this.decisionMakingLevel = decisionMakingLevel;
  }

  @Override
  public String getRole() {
    return this.role;
  }
}
