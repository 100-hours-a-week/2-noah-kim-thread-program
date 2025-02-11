package employees;

// 공통 상위 클래스
public abstract class Employee {

  private int salary;
  private int experienceYears;
  // TODO: role을 public static 으로 만들기 (모든 객체마다 가질 필요가 없는 고정된 값)
  private String role;

  // 생성자
  public Employee(int salary, int experienceYears, String role) {
    this.setSalary(salary);
    this.setExperienceYears(experienceYears);
    this.setRole(role);
  }

  public int getSalary() {
    return salary;
  }

  // TODO: salary 값을 검증하는 로직 필요
  public void setSalary(int salary) {
    this.salary = salary;
  }

  public int getExperienceYears() {
    return experienceYears;
  }

  // TODO: experienceYears 값을 검증하는 로직 필요
  public void setExperienceYears(int experienceYears) {
    this.experienceYears = experienceYears;
  }

  public String getRole() {
    return role;
  }

  // TODO: Role을 검증하는 로직 필요
  public void setRole(String role) {
    this.role = role;
  }

  // 추상 메소드
  public abstract String showProfile();
}


