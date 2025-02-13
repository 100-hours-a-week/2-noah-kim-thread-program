package lib.Threads;

import data.CompanyData;
import employees.Employee;
import lib.TimeTracker;

public class SalaryPaymentThread extends Thread {
  private final CompanyData companyData;
  private final TimeTracker timeTracker;

  public SalaryPaymentThread(CompanyData companyData, TimeTracker timeTracker) {
    this.companyData = companyData;
    this.timeTracker = timeTracker;
  }

  @Override
  public void run() {
    int lastSalaryTime = 0;
    try {
      while(timeTracker.isRunning()) {
        int elapsedTime = timeTracker.getElapsedTime();
        // 한달(5초)에 한번씩 임금을 지급한다.
        if(elapsedTime - lastSalaryTime >= 5) {
          lastSalaryTime = elapsedTime;
          processSalaryPayments();
        }
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      System.out.println("임금 지급 스레드 종료");
    }
  }

  private void processSalaryPayments() {
    System.out.println("💰 [임금 지급 시작] 현재 시간: " + timeTracker.getElapsedTimeString());
    System.out.println("🏢 이번 달 수익: " + CompanyData.companyFund + "원");

    int remainingSalary = CompanyData.companyFund;
    boolean isDone = false;

    // 1️⃣ 이전 미지급자 먼저 수령
    for(Employee emp : companyData.getUnpaidEmployees()) {
      if(remainingSalary > emp.getSalary() && !isDone) {
        remainingSalary -= emp.getSalary();
        companyData.pollUnpaidQueue(); // 미지급자에서 제거
        System.out.println("✅ 미지급자 " + emp.getRole() + "에게 " + emp.getSalary() + "만원 지급 완료!");
      }
      else {
        System.out.println("🚨 예산 부족! 미지급자 " + emp.getRole() + " 임금 지급 대기!");
        isDone = true;
      }
    }

    // 2️⃣ 이번달 지급자 지급
    for(Employee emp : companyData.getEmployees()) {
      if(remainingSalary > 0 && emp.getSalary() <= remainingSalary && !isDone) {
        remainingSalary -= emp.getSalary();
        System.out.println("✅ 이번달 지급자 " + emp.getRole() + "에게 " + emp.getSalary() + "만원 지급 완료!");
      }
      else {
        companyData.addUnpaidEmployee(emp);
        isDone = true;
        System.out.println("🚨 예산 부족! " + emp.getRole() + " 임금 지급 대기!");
      }
    }
    System.out.println();
  }

}
