package edu.vt.ece.hw4.barriers;

import edu.vt.ece.hw4.bench.Counter;

public class TTASBarrierFactory {

    public static Barrier getBarrier(Counter barrierCounter, int threadCount, String name) {
        switch(name) {
            case "First":
                return new FirstBarrier(barrierCounter, threadCount);
            case "Second":
                return new SecondBarrier(barrierCounter, threadCount);
        }
        return null;
    }

}
