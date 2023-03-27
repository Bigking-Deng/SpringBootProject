package exercise.proxyExercise;

public class MakeBreadService implements MakeFoodService{
    @Override
    public void makeFood(){

        try {
            System.out.println(String.format("prepare to make bread"));
            Thread.sleep(2000);
            System.out.println("making ...");
            Thread.sleep(5000);
            System.out.println("finish...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void postCleanProcess() {
        try {
            System.out.println("prepare to clean...");
            Thread.sleep(2000);
            System.out.println("cleaning...");
            Thread.sleep(5000);
            System.out.println("finish...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
