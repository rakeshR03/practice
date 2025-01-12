package thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 1, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(2), new CustomThreadFactory(), new CustomRejectedHandler());

        threadPoolExecutor.allowCoreThreadTimeOut(true);

        AtomicInteger count = new AtomicInteger(0);
        //submit task
        for (int i=0; i<5; i++) {
            threadPoolExecutor.submit(() -> {
                try {
                    System.out.println("Task started : "+count.incrementAndGet()+ ", by thread : "+Thread.currentThread().getName());
                    Thread.sleep(3000);
                } catch (Exception ex) {

                }
            });
        }

        threadPoolExecutor.shutdown();
    }
}
class CustomRejectedHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        // logging
        System.out.println("Task denied : "+ r.toString());
    }
}

class CustomThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        return thread;
    }
}
