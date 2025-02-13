package lib.Threads;

import lib.TimeTracker;

public class TimerThread extends Thread {
  private final TimeTracker timeTracker;

  public TimerThread(TimeTracker timeTracker) {
    this.timeTracker = timeTracker;
  }

  @Override
  public void run() {
    try {
      while (timeTracker.isRunning()) {
        timeTracker.incrementTime();
        Thread.sleep(1000); // 1초마다 시간 증가
      }
    } catch (InterruptedException e) {
      System.out.println("타이머 스레드 종료");
    }
  }
}

