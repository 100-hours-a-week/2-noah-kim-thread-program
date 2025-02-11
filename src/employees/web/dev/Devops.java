package employees.web.dev;

import employees.web.Developer;
import java.util.List;

public class Devops extends Developer {

  private static String role = "Devops";

  private int CICDLevel;
  private int cloudPlatformLevel;

  public Devops(int salary, int experienceYears, String domain, int communationLevel,
      List<String> stacks, int CICDLevel, int cloudPlatformLevel) {
    super(salary, experienceYears, domain, communationLevel, stacks);
    this.CICDLevel = CICDLevel;
    this.cloudPlatformLevel = cloudPlatformLevel;
  }

  public int getCICDLevel() {
    return CICDLevel;
  }

  public void setCICDLevel(int CICDLevel) {
    this.CICDLevel = CICDLevel;
  }

  public int getCloudPlatformLevel() {
    return cloudPlatformLevel;
  }

  public void setCloudPlatformLevel(int cloudPlatformLevel) {
    this.cloudPlatformLevel = cloudPlatformLevel;
  }

}
