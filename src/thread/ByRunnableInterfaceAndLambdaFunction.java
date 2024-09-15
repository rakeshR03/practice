package thread;

public class ByRunnableInterfaceAndLambdaFunction {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
         print(Thread.currentThread().getName());
        },"t1");

        Thread t2 = new Thread(() -> {
           print(Thread.currentThread().getName());
        }, "t2");

        t1.start();
        t2.start();
    }

    static void print(String thread) {
        for(int i=0; i<5; i++) {
            System.out.println(thread + " : " + i);
            try{
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
