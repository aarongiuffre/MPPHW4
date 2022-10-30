package edu.vt.ece.hw4.backoff;

public interface Backoff {
//    final int minDelay, maxDelay;
//    int limit;
//    public Backoff(int min, int max){
//        minDelay = min;
//        maxDelay = max;
//        limit = minDelay;
//    }
    void backoff() throws InterruptedException;
}
