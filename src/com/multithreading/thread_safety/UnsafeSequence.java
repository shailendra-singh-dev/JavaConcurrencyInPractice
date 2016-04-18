package com.multithreading.thread_safety;

import com.multithreading.annotations.NotThreadSafe;

@NotThreadSafe
public class UnsafeSequence {

  private int mValue;

  public int getNext() {
    return mValue;
  }

  public void service() {
    mValue++;
  }
  
}
