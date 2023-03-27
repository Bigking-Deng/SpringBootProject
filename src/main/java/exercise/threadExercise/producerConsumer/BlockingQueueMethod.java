package exercise.threadExercise.producerConsumer;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class BlockingQueueMethod {
    static Object producerLock = new Object();
    static Object consumerLock = new Object();
    static BlockingQueue<Product> arraywareHouse = new LinkedBlockingQueue<>(10);
    static BlockingQueue<Product> linkedwareHouse = new LinkedBlockingQueue<>(10);
    static AtomicInteger atomicInteger = new AtomicInteger(0);
    static int i = 0;

    public static void produce() throws InterruptedException {
        while(true){
            Thread.sleep(5000);
            //synchronized保证以下几个步骤组成整体原子性，防止打印queue.size的数字不对，blockingQueue只能保证当前queue.put操作是原子性，不能保证这些操作全是原子性
            synchronized (producerLock){
                Product product = new Product("p"+ atomicInteger.incrementAndGet(), new Random().nextInt(20));
//            Product product = new Product("p"+ i++, new Random().nextInt(20));
                //队列满时，put会一直阻塞，offer返回false，add报异常
                arraywareHouse.put(product);
                log.info(String.format("successfully produce a product %s and insert into warehouse, and the wareHouse size is %d", product.name, arraywareHouse.size()));
            }

        }
    }

    public static void consume() throws InterruptedException {
        while(true){
            Thread.sleep(10000);
            synchronized (consumerLock){
                Product product = arraywareHouse.take();
                log.info(String.format("successfully get a product %s , and the wareHouse size is %d", product.name, arraywareHouse.size()));
            }

        }
    }

    public static void main(String[] args) {
        BlockingQueueMethod blockingQueueMethod = new BlockingQueueMethod();
        BlockingQueueMethod.produceTask produceTask1 = blockingQueueMethod.new produceTask();
        BlockingQueueMethod.produceTask produceTask2 = blockingQueueMethod.new produceTask();
        BlockingQueueMethod.consumeTask consumeTask1 = blockingQueueMethod.new consumeTask();
        BlockingQueueMethod.consumeTask consumeTask2 = blockingQueueMethod.new consumeTask();
        BlockingQueueMethod.consumeTask consumeTask3 = blockingQueueMethod.new consumeTask();
        new Thread(produceTask1).start();
        new Thread(produceTask2).start();
        new Thread(consumeTask1).start();
//        new Thread(consumeTask2).start();
//        new Thread(consumeTask3).start();


    }

    class produceTask implements Runnable{

        @Override
        public void run() {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class consumeTask implements Runnable{

        @Override
        public void run() {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
