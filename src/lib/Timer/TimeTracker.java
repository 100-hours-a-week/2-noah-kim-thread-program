package lib.Timer;

import java.util.concurrent.atomic.AtomicInteger;

class TimeTracker {
  private final AtomicInteger elapsedTime = new AtomicInteger(0);
  private boolean running = true;

  public void incrementTime() {
    elapsedTime.incrementAndGet();
  }

  public long getElapsedTime() {
    return elapsedTime.get();
  }

  public void stopTracking() {
    running = false;
  }

  public boolean isRunning() {
    return running;
  }
}
