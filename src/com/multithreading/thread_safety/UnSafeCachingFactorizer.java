package com.multithreading.thread_safety;

import java.util.concurrent.atomic.AtomicReference;

import com.multithreading.annotations.NotThreadSafe;


@NotThreadSafe
public class UnSafeCachingFactorizer extends ConcurrencyServlet {

  private AtomicReference<Integer> mNumber = new AtomicReference<Integer>();
  private AtomicReference<Integer> mNumberFactor = new AtomicReference<Integer>();

  private int getFactorial(final int num) {
    if (num <= 0) {
      return 1;
    } else {
      return num * getFactorial(num - 1);
    }
  }

  @Override
  public void service(Object requestParam) {
    int number = (Integer) requestParam;
    if (null != mNumber.get() && mNumber.get() == number) {
      encodeIntoResponse("Number:" + number + ",factor:" + mNumberFactor.get());
    } else {
      mNumber.set(number);
      mNumberFactor.set(getFactorial(number));
    }
  }

}
