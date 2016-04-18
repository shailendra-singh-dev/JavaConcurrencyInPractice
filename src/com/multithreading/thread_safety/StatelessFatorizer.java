package com.multithreading.thread_safety;

import com.multithreading.annotations.ThreadSafe;

@ThreadSafe
public class StatelessFatorizer extends ConcurrencyServlet {


  @Override
  public void service(Object requestParam) {
    int value = (Integer) requestParam;
    final int incrementedValue = ++value;
    encodeIntoResponse("value:" + incrementedValue);
  }

}
