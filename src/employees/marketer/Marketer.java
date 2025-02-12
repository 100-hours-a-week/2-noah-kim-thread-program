package employees.marketer;

import employees.Employee;
import employees.Role;
import java.util.List;

public class Marketer extends Employee {

  private static Role role = Role.MARKETING_SPECIALIST;

  private List<String> languageSkills; // 사용가능 언어
  private int creativityLevel;     // 창의력
  private int persuasionLevel;     // 설득 능력

  public Marketer(int salary, int experienceYears, List<String> languageSkills,
      int creativityLevel, int persuasionLevel) {
    super(salary, experienceYears);
    this.languageSkills = languageSkills;
    this.creativityLevel = creativityLevel;
    this.persuasionLevel = persuasionLevel;
  }

  public List<String> getLanguageSkills() {
    return languageSkills;
  }

  public void setLanguageSkills(List<String> languageSkills) {
    this.languageSkills = languageSkills;
  }

  public int getCreativityLevel() {
    return creativityLevel;
  }

  public void setCreativityLevel(int creativityLevel) {
    this.creativityLevel = creativityLevel;
  }

  public int getPersuasionLevel() {
    return persuasionLevel;
  }

  public void setPersuasionLevel(int persuasionLevel) {
    this.persuasionLevel = persuasionLevel;
  }

  @Override
  public Role getRole() {
    return this.role;
  }
}