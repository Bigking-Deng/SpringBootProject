package exercise.threadExercise.producerConsumer;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ReentrantLockMethod {
    static Deque<Product> deque;
    static ReentrantLock reentrantLock;
    static Condition producer_condition;
    static Condition consumer_condition;
    static AtomicInteger atomicInteger = new AtomicInteger(0);
    static {
        deque = new ArrayDeque<>(10);
        reentrantLock = new ReentrantLock();
        producer_condition = reentrantLock.newCondition();
        consumer_condition = reentrantLock.newCondition();
    }

    public void produce(){
        while(true){
            try {
                Thread.sleep(3000);
                reentrantLock.lock();
                Product product = new Product("p" + atomicInteger.incrementAndGet(), new Random().nextInt(20));
                while(deque.size()>=10){
                    producer_condition.await();
                }
                deque.offer(product);
                log.info(String.format("successfully produce a product %s and insert into warehouse, and the wareHouse size is %d", product.name, deque.size()));
                consumer_condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }


    }

    public void consume(){
        while(true){
            try {
                Thread.sleep(10000);
                reentrantLock.lock();
                while(deque.isEmpty()){
                    consumer_condition.await();
                }
                Product product = deque.poll();
                log.info(String.format("successfully get a product %s , and the wareHouse size is %d", product.name, deque.size()));
                producer_condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }

    }

    public static void main(String[] args) {
        ReentrantLockMethod reentrantLockMethod = new ReentrantLockMethod();
        ProduceTask p1 = new ProduceTask();
        p1.setTarget(reentrantLockMethod);
        ProduceTask p2 = new ProduceTask();
        p2.setTarget(reentrantLockMethod);
        ConsumeTask c1 = new ConsumeTask();
        c1.setTarget(reentrantLockMethod);
        ConsumeTask c2 = new ConsumeTask();
        c2.setTarget(reentrantLockMethod);
        ConsumeTask c3 = new ConsumeTask();
        c3.setTarget(reentrantLockMethod);
        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(c3).start();
    }

}




class ProduceTask implements Runnable{
    private ReentrantLockMethod target;

    public ReentrantLockMethod getTarget() {
        return target;
    }

    public void setTarget(ReentrantLockMethod target) {
        this.target = target;
    }

    @Override
    public void run() {
        target.produce();
    }
}

class ConsumeTask implements Runnable{

    private ReentrantLockMethod target;

    public ReentrantLockMethod getTarget() {
        return target;
    }

    public void setTarget(ReentrantLockMethod target) {
        this.target = target;
    }


    @Override
    public void run() {
        target.consume();
    }
}
