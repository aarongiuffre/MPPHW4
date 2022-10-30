package edu.vt.ece.hw4.backoff;

public class PolynomialBackoff implements Backoff {
    static private int a;

    PolynomialBackoff(){
        a = 1;
    }

    @Override
    public void backoff() throws InterruptedException {
        Thread.sleep((long)Math.pow(a, Math.E));
        a++;
    }
}
