package thread.Future;

import java.util.concurrent.*;

public class FutureTest {
    public static void main(String[] args) {
        System.out.println("Main thread started");
        ThreadPoolExecutor threadPoolExecutor =  new ThreadPoolExecutor(1,1,1,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        Future<?> futureObj = threadPoolExecutor.submit(() ->
                {
                    try {
                        Thread.sleep(4000);
                        System.out.println("Task to be executed by thread");
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                });

        threadPoolExecutor.shutdown();

//        System.out.println("cancel thread : "+futureObj.cancel(true));

        System.out.println("Is thread executed: "+futureObj.isDone());
        System.out.println("Main thread end");
    }
}
