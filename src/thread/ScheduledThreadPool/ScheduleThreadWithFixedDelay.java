package thread.ScheduledThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadWithFixedDelay {
    public static void main(String[] args) {
        System.out.println("Main thread start");
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleWithFixedDelay(() -> {
            System.out.println("task started");
            try {
                Thread.sleep(6000);
            } catch (Exception ex) {
                System.out.println("exception : " + ex);
            }
            System.out.println("task ended");
        }, 1, 3, TimeUnit.SECONDS);
        System.out.println("main thread ended");
    }
}
