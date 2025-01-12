package thread.Future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class FutureUseCase1 {
    public static void main(String[] args) {
        System.out.println("Main thread start");
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        // 1st Use case
        Future<?> futureObj1 = pool.submit(() -> {
            System.out.println("Task1 with Runnable");
        });

        pool.shutdown();

        try {
            Object obj = futureObj1.get();
            System.out.println(obj == null);
        } catch (Exception ex) {
            System.out.println("exception 1 : "+ex);
        }

        System.out.println("Main thread end");
    }
}

