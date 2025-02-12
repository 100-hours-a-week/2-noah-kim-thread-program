package employees;

// 공통 상위 클래스
public abstract class Employee {

  private int salary;
  private int experienceYears;

  private Role role;
  // 생성자
  public Employee(int salary, int experienceYears) {
    this.setSalary(salary);
    this.setExperienceYears(experienceYears);
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  public int getExperienceYears() {
    return experienceYears;
  }

  public void setExperienceYears(int experienceYears) {
    this.experienceYears = experienceYears;
  }

  public abstract  Role getRole();
}


