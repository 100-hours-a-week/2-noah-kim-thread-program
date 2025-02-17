package employees;

import lib.TypeSafeScanner;

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

  // 연봉 선택 로직
  public void reselectSalary() {
    int salary;
    while (true) {
      salary = TypeSafeScanner.getValidInteger("연봉을 입력하세요: ");
      if (salary == this.salary) {
        System.out.println("같은 연봉입니다. 다시 입력하세요.");
      }
      else {
        break;
      }
    }
    this.salary = salary;
  }

  public abstract  Role getRole();
}


