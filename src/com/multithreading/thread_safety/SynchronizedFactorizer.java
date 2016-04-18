package com.multithreading.thread_safety;

import com.multithreading.annotations.GuardedBy;

public class SynchronizedFactorizer extends ConcurrencyServlet {

  @GuardedBy("this")
  private int mNumber;
  @GuardedBy("this")
  private int mNumberFactor;

  private int getFactorial(final int num) {
    if (num <= 0) {
      return 1;
    } else {
      return num * getFactorial(num - 1);
    }
  }

  @Override
  public synchronized void service(Object requestParam) {
    int number = (Integer) requestParam;
    if (0 != mNumber && mNumber == number) {
      encodeIntoResponse("Number:" + number + ",factor:" + mNumberFactor);
    } else {
      mNumber = number;
      mNumberFactor = getFactorial(number);
    }
  }
}
