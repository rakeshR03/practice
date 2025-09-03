package thread.ThreadLocal;


public class ThreadLocalTest {
    public static void main(String[] args) {
        System.out.println("main thread start");
        ThreadLocal<String> threadLocalObj = new ThreadLocal<>();

        // set thread-local variable for main thread
        threadLocalObj.set("main thread-local variable");

        // set thread-local variable for user thread
        Thread t1 = new Thread(() -> {
           threadLocalObj.set("user thread thread-local variable");
        });

        t1.start();
//
//        try {
//            Thread.sleep(3000);
//        } catch (Exception ex) {
//
//        }

        System.out.println("thread-local variable: " + threadLocalObj.get());
        System.out.println("main thread end");
    }
}
