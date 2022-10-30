package edu.vt.ece.hw4.backoff;

public class ExponentialBackoff implements Backoff {
    static private int a;

    ExponentialBackoff(){
        a = 1;
    }
    @Override
    public void backoff() throws InterruptedException {
        Thread.sleep(a);
        a *= 2;
    }
}
