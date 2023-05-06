package exercise.threadExercise;

//多个线程按顺序交替打印数字直到给定的上限，因为多个线程交替打印共用上限，所以需要同一个task对象，然后用同一个计数器
//和交替各自打印foo，bar完全不同，交替各自打印用各自的计数器count和task对象。
public class AlternatePrint2 {
    public static void main(String[] args) {
        int threadNum = 5;
        TaskInstance instance = TaskInstance.newInstance(20, threadNum);
        for(int i=0; i<threadNum; i++) {
            //操作的都是同一个instance对象
            new Thread(instance, String.valueOf(i)).start();
        }
    }
}


class TaskInstance implements Runnable{

    private int flag = 0;

    public int countNum = 0;

    public int threadNum = 0;

    private static int count = 0;

    private static Object lock = new Object();
    private static Object runlock = new Object();

    volatile static TaskInstance instance = null;

    private TaskInstance(int countNum, int threadNum){
        this.countNum = countNum;
        this.threadNum = threadNum;
    }
//双重校验的单例模式保证此实例只有一个对象，多个线程操作的都是这一个对象，会涉及线程安全的问题
    public static TaskInstance newInstance(int countNum, int threadNum){
        if(instance==null){
            synchronized (lock){
                if(instance==null){
                    instance = new TaskInstance(countNum, threadNum);
                }
            }
        }else{
            instance.countNum=countNum;
            instance.threadNum=threadNum;
        }
        return instance;
    }

    @Override
    public void run() {
        int id = Integer.valueOf(Thread.currentThread().getName());

        synchronized (runlock){
            //注意此处用while(true)和while(count < countNum)是一样的，因为就算此处进入了循环，可能有多个线程block了在
            //wait处，下面的count++还没起效其他线程都进入了循环，会出现最后输出一轮大于countNum的情况，有点类似于双重判断，必须在下面继续加一个
            //if(count <= countNum)判断保证线程在wait唤醒后继续判断count是否真正的小于countNum再操作并修改flag顺序，否则退出break
            //因为本质上每个线程运行run方法也只是运行一遍，要循环打印必须在run方法里有一个循环（其实就是普通方法调用，只是加入了多线程的概念）
             while(true){
            //此处要用while因为notifyAll会唤醒所有线程来加入新一轮抢锁，当不是正确顺序的线程抢到lock，要确保它从wait被唤醒后再次沉睡
            //因为除了某个正确顺序执行任务的线程，其他线程都在wait，当notifyAll后新一轮抢锁后，会从wait处继续执行，假如抢到锁的线程不是正确的顺序，就用while让他继续睡眠
                while(flag%threadNum!=id){
                    try {
                        runlock.wait();
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(count <= countNum) {
                    System.out.println("Content is: " + count + " . Thread Name is: " + id);
                    runlock.notifyAll();
                    flag++;
                    count++;
                }else{
                    break;
                }

            }
        }
    }


}
