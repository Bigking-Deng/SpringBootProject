package exercise.threadExercise;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ThreadMainJob {


    
    public static void main(String[] args) throws InterruptedException {
        TasksWithNoReturn task1 = new TasksWithNoReturn();
        Tasks2 task2 = new Tasks2();

//        Executor executor  = Executors.newFixedThreadPool(4);

        Thread t1 = new Thread(task1, "pool1");
        Thread t2 = new Thread(task2, "pool2");
        log.info("main thread start!");
//        t1.start();
        t2.start();
        firstExecThread(t2);
//        interruptTest(t1);
        log.info("main thread stop!");
    }

    public static void interruptTest(Thread thread){
        System.out.println("prepare to interrupt thread after 5s: " + thread.getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    public static void firstExecThread(Thread thread){
        try {
            thread.join();
        } catch (InterruptedException e) {
            log.warn("joining thread interrupted");
            e.printStackTrace();
        }
    }
    
}
