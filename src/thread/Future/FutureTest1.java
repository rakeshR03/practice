package thread.Future;

import java.util.concurrent.*;

public class FutureTest1 {
    public static void main(String[] args) {
        System.out.println("Main thread start");
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        Future<?> futureObj = pool.submit(() -> {
            try {
                Thread.sleep(7000);
                System.out.println("task to be executed by thread");
            } catch (Exception ex) {

            }
        });

        pool.shutdown();

        System.out.println("is done : "+futureObj.isDone());
        try {
            futureObj.get(1, TimeUnit.SECONDS);
        } catch (TimeoutException ex) {
            System.out.println("TimeOutException happened");
        } catch (Exception e) {
            System.out.println("Exception happened");
        }

        try {
            System.out.println("waiting to get future result");
            futureObj.get();
            System.out.println("future result retrieved");
        } catch (Exception ex) {

        }
        System.out.println("is done : " + futureObj.isDone());
        System.out.println("is cancelled : " + futureObj.isCancelled());
        System.out.println("Main thread end");
    }
}
