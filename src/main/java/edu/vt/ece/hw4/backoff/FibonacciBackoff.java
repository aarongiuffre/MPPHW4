package edu.vt.ece.hw4.backoff;

public class FibonacciBackoff implements Backoff {
    static private int prev;
    static private int cur;

    FibonacciBackoff(){
        prev = 0;
        cur = 1;
    }
    @Override
    public void backoff() throws InterruptedException {
        Thread.sleep(prev);
        int temp = cur;
        cur += prev;
        prev = temp;
    }
}
