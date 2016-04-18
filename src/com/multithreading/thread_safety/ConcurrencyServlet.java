package com.multithreading.thread_safety;

public abstract class ConcurrencyServlet {

  public abstract void service(final Object requestParam);

  public void encodeIntoResponse(final Object response) {
    System.out.println("\n Thread:" + Thread.currentThread().getName() + ",response:" + response);
  }
}
