package thread.Future;

import java.util.concurrent.*;

public class CompletableFutureSupplyAsyncTest {
    public static void main(String[] args) {
        try {
            System.out.println("Main thread start");
            ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS,
                    new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.AbortPolicy());

            CompletableFuture<String> asynTask = CompletableFuture.supplyAsync(() -> {
                // do something and return
                try {
                    Thread.sleep(7000);
                } catch (Exception e) {
                    System.out.println("e : "+e);
                }
                return "task completed by thread";

            }, pool);
            pool.shutdown();
            System.out.println("result : " + asynTask.get());
            System.out.println("Main thread end");
        } catch (Exception ex) {
            System.out.println("Exception : " + ex);
        }
    }
}
