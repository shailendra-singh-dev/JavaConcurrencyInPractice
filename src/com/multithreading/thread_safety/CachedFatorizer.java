package com.multithreading.thread_safety;

import java.math.BigInteger;

import com.multithreading.annotations.GuardedBy;

public class CachedFatorizer extends ConcurrencyServlet {

  @GuardedBy("this")
  private int mNumber;
  @GuardedBy("this")
  private int mNumberFactor;

  @GuardedBy("this")
  private int mHits;
  @GuardedBy("this")
  private int mCacheHits;

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
    int factor = 0;
    synchronized (this) {
      mHits++;
      if (mNumber == number) {
        mCacheHits++;
        factor = mNumberFactor;
      }
    }
    synchronized (this) {
      mNumber = number;
      mNumberFactor = getFactorial(number);
    }
    encodeIntoResponse("Hits:" + mHits + ",CacheHits:" + mCacheHits);
  }

  public int getCachedHits() {
    return mCacheHits;
  }

  public int getHits() {
    return mHits;
  }

}
