package thread.Future;

import java.util.concurrent.*;

public class CompletableFutureThenComposeTest {
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

            }, pool).thenCompose((String val) -> {
                System.out.println("then compose method Thread : " + Thread.currentThread().getName());
                return CompletableFuture.supplyAsync(() -> {
                    return val + " you";
                } );
            }).thenComposeAsync((String val) -> {
                System.out.println("then compose async method Thread : " + Thread.currentThread().getName());
                return CompletableFuture.supplyAsync(() -> {
                    return val + " Roy!";
                });
            }, pool);

            System.out.println("result : " + asynTask.get());
            pool.shutdown();
            System.out.println("Main thread end");
        } catch (Exception ex) {
            System.out.println("Exception : " + ex);
        }
    }
}
