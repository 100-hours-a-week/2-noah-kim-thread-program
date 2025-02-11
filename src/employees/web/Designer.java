package employees.web;

import employees.Employee;
import java.util.List;

public class Designer extends Employee {

  private int animationLevel;
  private int UIUXLevel;
  private List<String> designTools;

  public Designer(int salary, int experienceYears, String role, int animationLevel, int UIUXLevel,
      List<String> designTools) {
    super(salary, experienceYears, role);
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

  // TODO: Designer 프로필 보여주는 함수 만들기
  @Override
  public String showProfile() {
    return "";
  }
}
