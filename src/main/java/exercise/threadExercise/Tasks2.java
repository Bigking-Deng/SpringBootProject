package exercise.threadExercise;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Tasks2 implements Runnable{

    @Override
    public void run() {
        System.out.println("This P1 task needs to be done firstly in thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
            System.out.println("This P1 task is finished in thread: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            log.error("interrupted by others");
            e.printStackTrace();
        }
        System.out.println("some post processes in thread: " + Thread.currentThread().getName());
    }
}
