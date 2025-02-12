package lib.Timer;

import java.util.concurrent.atomic.AtomicInteger;

public class TimeTracker {

  private final AtomicInteger elapsedTime = new AtomicInteger(0);
  private boolean running = true;

  public void incrementTime() {
    elapsedTime.incrementAndGet();
  }

  public int getElapsedTime() {
    return elapsedTime.get();
  }

  public void stopTracking() {
    running = false;
  }

  public boolean isRunning() {
    return running;
  }
}
