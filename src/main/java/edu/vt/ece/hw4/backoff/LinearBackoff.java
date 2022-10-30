package edu.vt.ece.hw4.backoff;

public class LinearBackoff implements Backoff {
    static private int attempt;

    LinearBackoff(){
        attempt = 0;
    }
    @Override
    public void backoff() throws InterruptedException {
        Thread.sleep(attempt);
        attempt++;
    }
}
