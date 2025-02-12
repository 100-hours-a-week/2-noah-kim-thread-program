package employees.web.dev;

import employees.web.Developer;
import java.util.List;

public class Frontend extends Developer {

  private final String role = "Frontend";

  private int cssLevel;
  private int testinglevel;

  public Frontend(int salary, int experienceYears, String domain, int communationLevel,
      List<String> stacks, int cssLevel, int testinglevel) {
    super(salary, experienceYears, domain, communationLevel, stacks);
    this.cssLevel = cssLevel;
    this.testinglevel = testinglevel;
  }

  public int getCssLevel() {
    return cssLevel;
  }

  public void setCssLevel(int cssLevel) {
    this.cssLevel = cssLevel;
  }

  public int getTestinglevel() {
    return testinglevel;
  }

  public void setTestinglevel(int testinglevel) {
    this.testinglevel = testinglevel;
  }

  @Override
  public String getRole() {
    return this.role;
  }
}
