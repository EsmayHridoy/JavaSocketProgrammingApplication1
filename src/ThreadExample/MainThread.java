package ThreadExample;

public class MainThread {
    public static void main(String[] args){
        new NewThread("1");
        new NewThread("2");
        System.out.println("This is main Thread");
        for(int i=20;i>0;i--){
            System.out.println("Main Thread "+i);
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Main thread work done");
    }
}
