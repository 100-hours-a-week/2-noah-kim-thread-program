package data;

import employees.Employee;
import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class CompanyData {
  private final List<Employee> employees = new ArrayList<>();
  private final Queue<Employee> unpaidQueue = new PriorityBlockingQueue<>(10, Comparator.comparing(Employee::getSalary).reversed()); // 연봉 높은 순 정렬

  private static final int companyFund = 50000; // 회사 예산 (초기 설정)

  public List<Employee> getEmployees() {
    return this.employees;
  }
  public void addEmployee(Employee employee) {
    this.employees.add(employee);
  }

  public int getSumSalary() {
    int size = this.employees.size();
    int totalSalary = 0;
    for (int i = 0; i < size; i++) {
      totalSalary += employees.get(i).getSalary();
    }
    return totalSalary;
  }

  public synchronized void addToUnpaidQueue(Employee employee) {
    unpaidQueue.offer(employee);
  }

  public synchronized Employee pollUnpaidQueue() {
    return unpaidQueue.poll();
  }

  public synchronized boolean hasUnpaidEmployees() {
    return !unpaidQueue.isEmpty();
  }

  public synchronized List<Employee> getEmployeesSortedBySalary() {
    employees.sort(Comparator.comparing(Employee::getSalary).reversed()); // 연봉 높은 순 정렬
    return employees;
  }


}

