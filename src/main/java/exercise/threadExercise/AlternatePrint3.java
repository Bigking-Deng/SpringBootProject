package exercise.threadExercise;

//交替按顺序打印，但是是每个线程打印相同的次数的内容，所以此题每个线程使用的run方法都是独立的，独立计数次数
//只是抢锁和控制顺序的flag还是公用的，之前的AlternatePrint2那题要共用打印计数，所以只用了一个实例task，
// 其实AlternatePrint2也可以写成多个实例然后公用一个static计数器，但这题就必须使用多个实例
public class AlternatePrint3 {

    public static void main(String[] args) {

        int ct = 0;
        int threadNum = 5;
        TaskEmp.init(threadNum);
        while(ct<threadNum){
            //多个实例Task，公用的变量直接设成static类变量
            new Thread(new TaskEmp(10), String.valueOf(ct)).start();
            ct++;
        }


    }
}

class TaskEmp implements Runnable{
    private static int flag = 0;

    public int count = 0;

    public static int threadNum = 0;

    public static String[] str = {"foo", "bar", "kii", "adk", "dhi", "daa", "pos"};

    private static Object runlock = new Object();

    public TaskEmp(int count){
        this.count = count;
    }

    public static void init(int threadNum){
        TaskEmp.threadNum = threadNum;

    }

    @Override
    public void run() {
        int id = Integer.valueOf(Thread.currentThread().getName());
        for(int i=0; i<count; i++){
            synchronized (runlock){
                while(flag%threadNum!=id){
                    try {
                        runlock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Content is: " + str[id] + " . Thread Name is: " + id);
                runlock.notifyAll();
                flag++;
            }
        }
    }
}
