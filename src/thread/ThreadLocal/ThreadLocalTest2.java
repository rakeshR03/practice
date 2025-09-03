package thread.ThreadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest2 {
    public static void main(String[] args) {
        System.out.println("Main thread start");
        ThreadLocal<String> threadLocalObj = new ThreadLocal<>();
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit(() -> {
            threadLocalObj.set("thread-local var1");
            threadLocalObj.remove();
        });

        for (int i=0; i<5; i++) {
            pool.submit(() -> {
                System.out.println(Thread.currentThread().getName() +" : " + threadLocalObj.get());
            });

        }
        pool.shutdown();

        System.out.println("Main thread end");
    }
}
