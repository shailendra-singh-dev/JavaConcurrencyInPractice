package com.multithreading.visibility;

import java.io.Reader;

public class NoVisibility {

  private static boolean isReady = false;
  private static int number = 0;

  private static class ReaderThread extends Thread {

    @Override
    public void run() {
      super.run();
      while (!isReady) {
        yield();
      }
      System.out.println("\n Values isReady:" + isReady + ",number:" + number);
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    new ReaderThread().start();
    isReady = true;
    number = 100;
  }
}
