package thread.ScheduledThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadAtFixedRate {
    public static void main(String[] args) {
        System.out.println("Main thread start");
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        Future<?> futureObj = service.scheduleAtFixedRate(() -> {
            System.out.println("executing task after delay");
        }, 3, 5, TimeUnit.SECONDS);
        try {
            Thread.sleep(10000);
            futureObj.cancel(true);
            System.out.println("Task cancelled");
        } catch (Exception ex) {
            System.out.println("exception : " + ex);
        }
        System.out.println("main thread end");
    }
}
