package com.multithreading.thread_safety;

import com.multithreading.annotations.NotThreadSafe;

@NotThreadSafe
public class LazyInitRace {

  
  private LazyInitRace mLazyInitRace;
  
  public LazyInitRace getInstance(){
    if(null == mLazyInitRace){
      mLazyInitRace =new LazyInitRace();
    }
    return mLazyInitRace;
  }
  
}
