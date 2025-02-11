package employees.web.dev;

import employees.web.Developer;
import java.util.List;

public class Backend extends Developer {

  private int databaseLevel; // DB 활용 능력
  private int securityLevel; // 보안 적용 능력

  public Backend(int salary, int experienceYears, String role, String domain, int communationLevel,
      List<String> stacks, int databaseLevel, int securityLevel) {
    super(salary, experienceYears, role, domain, communationLevel, stacks);
    this.databaseLevel = databaseLevel;
    this.securityLevel = securityLevel;
  }

  public int getDatabaseLevel() {
    return databaseLevel;
  }

  public void setDatabaseLevel(int databaseLevel) {
    this.databaseLevel = databaseLevel;
  }

  public int getSecurityLevel() {
    return securityLevel;
  }

  public void setSecurityLevel(int securityLevel) {
    this.securityLevel = securityLevel;
  }

  // TODO: Backend 프로필 보여주는 함수 만들기
  @Override
  public String showProfile() {
    return "";
  }
}
