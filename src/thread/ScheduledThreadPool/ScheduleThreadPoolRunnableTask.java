package thread.ScheduledThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPoolRunnableTask {
    public static void main(String[] args) {
        System.out.println("Main thread start");
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.schedule(() -> {
            System.out.println("Scheduled task run after 3 seconds delay");
        }, 3, TimeUnit.SECONDS);

        System.out.println("Main thread end");
    }
}
