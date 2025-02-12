package employees.web.dev;

import employees.Role;
import employees.web.Developer;
import java.util.List;

public class Backend extends Developer {

  private final Role role = Role.BACKEND_DEVELOPER;

  private int databaseLevel; // DB 활용 능력
  private int securityLevel; // 보안 적용 능력

  public Backend(int salary, int experienceYears, String domain, int communationLevel,
      List<String> stacks, int databaseLevel, int securityLevel) {
    super(salary, experienceYears, domain, communationLevel, stacks);
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

  @Override
  public Role getRole() {
    return this.role;
  }
}
