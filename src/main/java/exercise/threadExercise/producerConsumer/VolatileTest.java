package exercise.threadExercise.producerConsumer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VolatileTest {
    volatile int flag = 0;
    public void changeFlag(){
        this.flag = 1;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest vi = new VolatileTest();
        new Thread(()->{
            try {
                Thread.sleep(3000);
                vi.changeFlag();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        int count=0;
        while(vi.flag==0){
//          Thread.sleep(1);
        }
        log.info("flag change to 1");
    }
}