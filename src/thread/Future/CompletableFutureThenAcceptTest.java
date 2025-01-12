package thread.Future;

import java.util.concurrent.*;

public class CompletableFutureThenAcceptTest {
    public static void main(String[] args) {
        try {
            System.out.println("Main thread start");
            ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 3, 1, TimeUnit.HOURS,
                    new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.AbortPolicy());

            CompletableFuture<Void> asyncTask = CompletableFuture.supplyAsync(() -> {
                // do something and return
                System.out.println("supply async method Thread : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    System.out.println("e : "+e);
                }
                return "Thank";

            }, pool).thenAccept((String val) -> {
                System.out.println("then accept method Thread : " + Thread.currentThread().getName());
                System.out.println("All");
            });

            System.out.println("result : " + asyncTask.get());
            pool.shutdown();
            System.out.println("Main thread end");
        } catch (Exception ex) {
            System.out.println("Exception : " + ex);
        }
    }
}
