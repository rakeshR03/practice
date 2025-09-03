package thread.ScheduledThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadAtFixedRateScenario2 {
    public static void main(String[] args) {
        System.out.println("main thread start");
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        pool.scheduleAtFixedRate(() -> {
            System.out.println("Task started");
            try {
                Thread.sleep(6000);
            } catch (Exception ex) {
                System.out.println("exception : "+ex);
            }
            System.out.println("Task ended");
        }, 3, 3, TimeUnit.SECONDS);
        System.out.println("main thread ended");
    }
}
