package edu.vt.ece.hw4.barriers;

import edu.vt.ece.hw4.bench.Counter;
import edu.vt.ece.hw4.locks.Lock;

public class FirstBarrier implements Barrier {
    private final Counter counter;
    private int threadCount;
    public FirstBarrier(Counter barrierCounter, int threadCount) {
        this.counter = barrierCounter;
        this.threadCount = threadCount;
    }

    @Override
    public void enter() {
        //lock.lock();
        foo();
        int count = counter.getAndIncrement(); //lock and unlock are done in the counter
        //lock.unlock();
        while(count < threadCount){
            try {
                Thread.sleep(1);
                count = counter.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        bar();
    }

    @Override
    public void foo() {
        System.out.println("FOO!");
    }

    @Override
    public void bar() {
        System.out.println("BAR!");
    }
}
