package data;

import java.util.concurrent.atomic.AtomicInteger;

public class ElapsedTime {

  private final AtomicInteger elapsedTime = new AtomicInteger(0);
  private boolean running = true;

  public void incrementTime() {
    elapsedTime.incrementAndGet();
  }

  public int getElapsedTime() {
    return elapsedTime.get();
  }

  public String getElapsedTimeString() {
    int elapsed = elapsedTime.get();
    int elapsedSeconds = elapsed % 60;      // 초 계산
    int elapsedMinutes = elapsed / 60;      // 분 계산 (3600으로 나누는 게 아님)

    if (elapsedMinutes > 0) {
      return elapsedMinutes + "분 " + elapsedSeconds + "초";
    } else {
      return elapsedSeconds + "초";
    }
  }

  public void stopTracking() {
    running = false;
  }

  public boolean isRunning() {
    return running;
  }
}
