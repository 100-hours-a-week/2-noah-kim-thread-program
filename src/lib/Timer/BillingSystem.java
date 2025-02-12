package lib.Timer;

import java.util.concurrent.atomic.AtomicInteger;

public class BillingSystem {
  private static final double COST_PER_SECOND = 0.05; // 1초당 0.05원

  public static double calculateFee(int elapsedTime) {
    return elapsedTime * COST_PER_SECOND;
  }
}
