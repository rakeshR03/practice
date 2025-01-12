package thread.Future;

import java.util.concurrent.*;

public class CompletableFutureThenCombineTest {
    public static void main(String[] args) {
        try {
            System.out.println("Main thread start");
            ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 3, 1, TimeUnit.HOURS,
                    new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.AbortPolicy());

            CompletableFuture<Integer> asyncTask1 = CompletableFuture.supplyAsync(() -> {
                // do something and return
                System.out.println("supply async method1 Thread : " + Thread.currentThread().getName());
                return 10;

            }, pool);

            CompletableFuture<String> asyncTask2 = CompletableFuture.supplyAsync(() -> {
                // do something and return
                System.out.println("supply async method2 Thread : " + Thread.currentThread().getName());
                return "k";

            }, pool);

            CompletableFuture<String> asyncTask3 = asyncTask1.thenCombine(asyncTask2, (Integer val1, String val2) -> {
                System.out.println("then combine method Thread : " + Thread.currentThread().getName());
                return val1 + val2;
            });

            CompletableFuture<String> asyncTask4 = asyncTask1.thenCombine(asyncTask2, (Integer val1, String val2) -> {
                System.out.println("then combine async method Thread : " + Thread.currentThread().getName());
                return val1 + val2;
            });

            System.out.println("result : " + asyncTask3.get());
            pool.shutdown();
            System.out.println("Main thread end");
        } catch (Exception ex) {
            System.out.println("Exception : " + ex);
        }
    }
}
