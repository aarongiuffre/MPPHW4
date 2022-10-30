package edu.vt.ece.hw4.bench;
import edu.vt.ece.hw4.barriers.Barrier;

public class BarrierTestThread extends Thread implements ThreadId {
    private static int ID_GEN = 0;
    //private Counter counter;
    private int id;
    private long elapsed;
    //private int iter;
    private static Barrier b;

    public BarrierTestThread(Barrier b) {
        id = ID_GEN++;
        //this.counter = counter;
        //this.iter = iter;
        this.b = b;
    }

    public static void reset() {
        ID_GEN = 0;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();

//        for(int i=0; i<iter; i++)
//            counter.getAndIncrement();
        b.enter();

        long end = System.currentTimeMillis();
        elapsed = end - start;
    }

    public int getThreadId(){
        return id;
    }

    public long getElapsedTime() {
        return elapsed;
    }
}
