package com.multithreading.main;

import com.multithreading.thread_safety.ConcurrencyServlet;
import com.multithreading.thread_safety.CountingFactorizer;
import com.multithreading.thread_safety.LazyInitRace;
import com.multithreading.thread_safety.LoggingWidget;
import com.multithreading.thread_safety.StatelessFatorizer;
import com.multithreading.thread_safety.UnSafeCachingFactorizer;
import com.multithreading.thread_safety.UnsafeSequence;

public class ThreadC extends Thread {

  private Object mObject;

  public ThreadC(final Object object) {
    super("ThreadC");
    mObject = object;
  }

  @Override
  public void run() {
    super.run();
    if (mObject instanceof ConcurrencyServlet) {
      testConcurrencyServlet((ConcurrencyServlet) mObject);
    }
    if (mObject instanceof UnsafeSequence) {
      testUnSafeSequence((UnsafeSequence) mObject);
    }
    if (mObject instanceof LazyInitRace) {
      testLazyInitRace((LazyInitRace) mObject);
    }
    if (mObject instanceof CountingFactorizer) {
      testCountingFactorizer((CountingFactorizer) mObject);
    }
    if (mObject instanceof LoggingWidget) {
      testLoggingWidget((LoggingWidget) mObject);
    }
  }

  private void testLoggingWidget(LoggingWidget loggingWidget) {
    loggingWidget.doSomething();
  }

  private void testConcurrencyServlet(ConcurrencyServlet mObject) {
    mObject.service(5);
  }

  private void testCountingFactorizer(CountingFactorizer mObject) {
    mObject.service();
    System.out.println("\n :" + getName() + ",value:" + mObject.getProcessedValue());
  }

  private void testLazyInitRace(LazyInitRace mObject) {
    final LazyInitRace lazyInitRace = mObject.getInstance();
    System.out.println("\n :" + getName() + ",lazyInitRace:" + lazyInitRace);
  }

  private void testUnSafeSequence(final UnsafeSequence unsafeSequence) {
    unsafeSequence.service();
    System.out.println("\n :" + getName() + ",next:" + unsafeSequence.getNext());
  }


}
