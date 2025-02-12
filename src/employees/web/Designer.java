package employees.web;

import employees.Employee;
import java.util.List;

public class Designer extends Employee {

  private static String role = "Designer";

  private int animationLevel;
  private int UIUXLevel;
  private List<String> designTools;

  public Designer(int salary, int experienceYears, int animationLevel, int UIUXLevel,
      List<String> designTools) {
    super(salary, experienceYears);
    this.animationLevel = animationLevel;
    this.UIUXLevel = UIUXLevel;
    this.designTools = designTools;
  }

  public int getAnimationLevel() {
    return animationLevel;
  }

  public void setAnimationLevel(int animationLevel) {
    this.animationLevel = animationLevel;
  }

  public int getUIUXLevel() {
    return UIUXLevel;
  }

  public void setUIUXLevel(int UIUXLevel) {
    this.UIUXLevel = UIUXLevel;
  }

  public List<String> getDesignTools() {
    return designTools;
  }

  public void setDesignTools(List<String> designTools) {
    this.designTools = designTools;
  }

}
