package com.multithreading.thread_safety;

public class LoggingWidget extends Widget {

  @Override
  public void doSomething() {
    System.out.println("\n Thread:" + Thread.currentThread().getName()
        + " doSomething in  LoggingWidget Class");
    super.doSomething();
  }
}
