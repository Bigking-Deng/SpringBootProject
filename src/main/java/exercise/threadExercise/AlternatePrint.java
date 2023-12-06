package exercise.threadExercise;

import java.util.concurrent.CountDownLatch;

public class AlternatePrint {

    //notify后释放锁，仍是两个线程争抢锁，为了保证一定是另一个线程抢到，设立flag控制顺序
    static int flag = 0;
    static Class lockObj = AlternatePrint.class;
    public void printFoo(int count) throws InterruptedException {
        synchronized (lockObj){
            for(int i=0; i<count; i++){
                while( flag==1){
                    lockObj.wait();
                }
                System.out.println(i + ": Foo");
                lockObj.notify();
                flag=1;
            }
        }

    }


    public void printBar(int count) throws InterruptedException {
        synchronized (lockObj){
            for(int i=0; i<count; i++){
                while(flag==0){
                    lockObj.wait();
                }
                System.out.println(i + ": Bar");
                lockObj.notify();
                flag = 0;
            }
        }

    }

    public static void main(String[] args) {
        AlternatePrint alternatePrint = new AlternatePrint();
        int count = 5;
        new Thread(()->{
            try {
                alternatePrint.printFoo(count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                alternatePrint.printBar(count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
