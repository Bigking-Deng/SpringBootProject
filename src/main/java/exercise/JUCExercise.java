package exercise;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class JUCExercise {
    static int s = 0;
    static AtomicIntegerFieldUpdater<Integer> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Integer.class, "s");

}
