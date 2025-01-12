package thread.Future;

import java.util.concurrent.*;

public class CompletableFutureThenApplyTest {
    public static void main(String[] args) {
        try {
            System.out.println("Main thread start");
            ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 3, 1, TimeUnit.HOURS,
                    new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.AbortPolicy());

            CompletableFuture<String> asynTask = CompletableFuture.supplyAsync(() -> {
                // do something and return
                System.out.println("supply async method Thread : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    System.out.println("e : "+e);
                }
                return "Thank";

            }, pool).thenApply((String val) -> {
                System.out.println("then apply method Thread : " + Thread.currentThread().getName());
                return val + " you";
            }).thenApplyAsync((String val) -> {
                System.out.println("then apply async method Thread : " + Thread.currentThread().getName());
                return val + " Roy!";
            }, pool);

            System.out.println("result : " + asynTask.get());
            pool.shutdown();
            System.out.println("Main thread end");
        } catch (Exception ex) {
            System.out.println("Exception : " + ex);
        }
    }
}
