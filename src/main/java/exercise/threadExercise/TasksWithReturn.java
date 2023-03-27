package exercise.threadExercise;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Callable;

@Slf4j
public class TasksWithReturn implements Callable {

    @Override
    public Integer call() {
        System.out.println("start to do task in thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.warn("task interrupted by some others in thread:" + Thread.currentThread().getName());
            e.printStackTrace();
        }
        System.out.println("finish task in thread: " + Thread.currentThread().getName());
        return new Random().nextInt(10);
    }
}
