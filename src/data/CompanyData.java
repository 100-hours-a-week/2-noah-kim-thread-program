package data;

import employees.Employee;
import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class CompanyData {
  private final List<Employee> employees = new ArrayList<>();
  private final Queue<Employee> unpaidEmployees = new PriorityBlockingQueue<>(10, Comparator.comparing(Employee::getSalary).reversed()); // 연봉 높은 순 정렬

  public static final int companyFund = 12000; // 회사 예산 (초기 설정)

  //1️⃣ Employee
  public List<Employee> getEmployees() {
    return this.employees;
  }

  public synchronized void addEmployee(Employee employee) {
    this.employees.add(employee);
  }

  public synchronized  void removeEmployee(Employee employee) {
    this.employees.remove(employee);
  }

  public int getSumSalary() {
    int size = this.employees.size();
    int totalSalary = 0;
    for (int i = 0; i < size; i++) {
      totalSalary += employees.get(i).getSalary();
    }
    return totalSalary;
  }

  // 2️⃣ unpaidEmployees
  public Queue<Employee> getUnpaidEmployees() {
    return unpaidEmployees;
  }

  public synchronized int getUnpaidQueueSize() {
    return this.unpaidEmployees.size();
  }

  public synchronized void addUnpaidEmployee(Employee employee) {
    unpaidEmployees.offer(employee);
  }

  public synchronized Employee pollUnpaidQueue() {
    return unpaidEmployees.poll();
  } // 큐에서 가장 우선순위가 높은 객체를 반환(제거)

  public synchronized  void removeFromUnpaidQueue(Employee employee) {
    unpaidEmployees.removeAll(Collections.singleton(employee));
  }

}

