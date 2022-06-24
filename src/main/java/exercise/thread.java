package exercise;


import java.util.concurrent.*;

public class thread {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Callable callable1 = new task1();
        Callable callable2 = new task1();
        Runnable runnable = new task2();
        FutureTask futureTask1 = new FutureTask(callable1);
//        FutureTask futureTask2 = new FutureTask(callable2);
        Future future = executorService.submit(callable1);
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(()->{
            System.out.println("task2 Thread Name: " + Thread.currentThread().getName());
            return 66;
        }, executorService);

        Object res1 = null;
        Object res2 = null;
        try {
            res1 = future.get();
//            res2 = futureTask2.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("res1: " + res1.toString());
        System.out.println("res2: " + res2.toString());
        System.out.println("main thread end");

    }

}

class task1 implements Callable<Integer>{

    @Override
    public Integer call(){
        System.out.println("task1 Thread Name: " + Thread.currentThread().getName());
        return 5*5;
    }
}

class task2 implements Runnable{

    @Override
    public void run() {
        System.out.println("task2 Thread Name: " + Thread.currentThread().getName());
    }
}
