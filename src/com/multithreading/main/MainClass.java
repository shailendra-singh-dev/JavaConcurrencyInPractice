package com.multithreading.main;

import com.multithreading.thread_safety.CachedFatorizer;
import com.multithreading.thread_safety.CountingFactorizer;
import com.multithreading.thread_safety.LazyInitRace;
import com.multithreading.thread_safety.LoggingWidget;
import com.multithreading.thread_safety.StatelessFatorizer;
import com.multithreading.thread_safety.SynchronizedFactorizer;
import com.multithreading.thread_safety.UnSafeCachingFactorizer;
import com.multithreading.thread_safety.UnsafeSequence;

public class MainClass {

  final static Object mObject1 = new UnsafeSequence();
  final static Object mObject2 = new StatelessFatorizer();
  final static Object mObject3 = new LazyInitRace();
  final static Object mObject4=new CountingFactorizer();
  final static Object mObject5=new UnSafeCachingFactorizer();
  final static Object mObject6=new SynchronizedFactorizer();
  final static LoggingWidget mLoggingWidget= new LoggingWidget();
  final static CachedFatorizer mCachedFatorizer = new CachedFatorizer();
  
  final static ThreadA mThreadA = new ThreadA(mCachedFatorizer);
  final static ThreadB mThreadB = new ThreadB(mCachedFatorizer);
  final static ThreadC mThreadC = new ThreadC(mCachedFatorizer);

  public static void main(String[] args) {
    testConcurrency();
  }

  private static void testConcurrency() {
    mThreadA.start();
    mThreadB.start();
    mThreadC.start();
  }
  
  static{
   //load annotations.. 
  }
}
