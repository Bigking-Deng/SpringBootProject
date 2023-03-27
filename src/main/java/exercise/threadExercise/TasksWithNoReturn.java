package exercise.threadExercise;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TasksWithNoReturn implements Runnable{

    @Override
    public void run() {
        System.out.println("start to do task in thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(7000);
            System.out.println("continue to finish task in thread: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            log.warn("task interrupted by some other thread" );
//            e.printStackTrace();
        }
//        System.out.println("continue to finish task in thread: " + Thread.currentThread().getName());
    }
}
