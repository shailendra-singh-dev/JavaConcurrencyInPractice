package com.multithreading.thread_safety;

public class Widget {

  public void doSomething() {
    System.out.println("\n Thread:" + Thread.currentThread().getName()
        + " doSomething in  Widget Class");
  }

}
