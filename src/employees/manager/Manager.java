package employees.manager;

import employees.Employee;

public class Manager extends Employee {

  String domain;
  int leadershipLevel;
  int decisionMakingLevel;

  public Manager(int salary, int experienceYears, String role, String domain, int leadershipLevel,
      int decisionMakingLevel) {
    super(salary, experienceYears, role);
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

  // TODO: Manager 프로필 보여주는 함수 만들기
  @Override
  public String showProfile() {
    return "";
  }
}
