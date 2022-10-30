package edu.vt.ece.hw4.backoff;

public class FixedBackoff implements Backoff {
    private int[] fixedNums;
    static private int attempt = 0;

    FixedBackoff(){
        fixedNums = new int[]{3, 7, 2, 4, 8, 1, 5, 9, 6};
    }
    @Override
    public void backoff() throws InterruptedException {
        Thread.sleep(fixedNums[(attempt + 9) % 9]);
        attempt++;
    }
}
