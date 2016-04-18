package com.multithreading.thread_safety;

import java.util.concurrent.atomic.AtomicLong;

import com.multithreading.annotations.ThreadSafe;

@ThreadSafe
public class CountingFactorizer  {

  private AtomicLong mValue=new AtomicLong();
  
  public long getProcessedValue(){
    return mValue.get();
  }
  
  public void service(){
    mValue.incrementAndGet();
  }
  
}
