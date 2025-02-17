package Threads;

import data.ElapsedTime;

public class TimerThread extends Thread {
  private final ElapsedTime elapsedTime;

  public TimerThread(ElapsedTime elapsedTime) {
    this.elapsedTime = elapsedTime;
  }

  @Override
  public void run() {
    try {
      while (elapsedTime.isRunning()) {
        elapsedTime.incrementTime();
        Thread.sleep(1000); // 1초마다 시간 증가
      }
    } catch (InterruptedException e) {
      System.out.println("타이머 스레드 종료");
    }
  }
}

