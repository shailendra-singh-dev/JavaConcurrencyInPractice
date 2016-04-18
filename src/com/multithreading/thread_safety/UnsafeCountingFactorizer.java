package com.multithreading.thread_safety;

public class UnsafeCountingFactorizer extends ConcurrencyServlet {

  private int mCount;

  @Override
  public void service(Object requestParam) {
    mCount++;
    encodeIntoResponse("value:" + getCount());
  }

  public int getCount() {
    return mCount;
  }

}
