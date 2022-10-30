package edu.vt.ece.hw4.barriers;

import edu.vt.ece.hw4.bench.Counter;
import edu.vt.ece.hw4.locks.Lock;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.lang.Thread;

public class SecondBarrier implements Barrier {

    private final Counter counter;
    private int threadCount;
    private AtomicIntegerArray b;
    private long fooTime;
    private long barTime;
    public SecondBarrier(Counter barrierCounter, int threadCount) {
        this.counter = barrierCounter;
        this.threadCount = threadCount;
        this.b = new AtomicIntegerArray(threadCount);
    }

    @Override
    public void enter() {
        int threadNum = (int) Thread.currentThread().getId() % threadCount;
        //System.out.println(threadNum);
        if(threadNum == 0){
            foo();
            b.set(threadNum, 1);
            //System.out.println("Thread " + threadNum+ " value: " + b.get(threadNum));
            while(b.get((threadCount - 1)) < 2){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            bar();
            return;
        }
        else if(threadNum > 0 && threadNum < (threadCount - 1)){
            foo();
            while(b.get((threadNum - 1)) == 0){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            b.set(threadNum, 1);
            //System.out.println("Thread " + threadNum+ " value: " + b.get(threadNum));
            while(b.get((threadCount - 1)) < 2){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            bar();
            return;
        }
        else if(threadNum == (threadCount - 1)){
            foo();
            while(b.get((threadNum - 1)) == 0){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            b.set(threadNum, 1);
            //System.out.println("Thread " + threadNum+ " value: " + b.get(threadNum));
            while(b.get(threadNum) != 1){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            b.set(threadNum, 2);
            bar();
        }
    }

    @Override
    public void foo() {
        //System.out.println("FOO!");
        fooTime = System.currentTimeMillis();
    }

    @Override
    public void bar() {
        //System.out.println("BAR!");
        barTime = System.currentTimeMillis();

    }
}
