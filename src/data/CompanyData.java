package data;

import employees.Employee;
import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class CompanyData {
  public static final int Fund = 50000; // 회사 예산 (초기 설정)

  private final List<Employee> employees = new ArrayList<>();
  private final Queue<Employee> unpaidQueue = new PriorityBlockingQueue<>(10, Comparator.comparing(Employee::getSalary).reversed()); // 연봉 높은 순 정렬

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

  public synchronized List<Employee> getUnpaidEmployees() {
    // 1️⃣ 먼저 unpaidQueue의 직원들을 리스트로 변환
    List<Employee> unpaidList = new ArrayList<>(unpaidQueue);

    // 2️⃣ 일반 직원(employees)도 정렬 (연봉 높은 순)
    List<Employee> sortedEmployees = new ArrayList<>(employees);
    sortedEmployees.sort(Comparator.comparing(Employee::getSalary).reversed());

    // 3️⃣ unpaidList + sortedEmployees를 합쳐서 반환
    List<Employee> finalList = new ArrayList<>();
    finalList.addAll(unpaidList);
    finalList.addAll(sortedEmployees);

    return finalList;
  }



}

