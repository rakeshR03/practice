package thread.ScheduledThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolCallableTask {
    public static void main(String[] args) {
        System.out.println("Main thread start");
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        Future<String> futureObj = service.schedule(() -> {
            return "returning scheduled task after delay";
        }, 3 , TimeUnit.SECONDS);

        try {
            System.out.println("future : " + futureObj.get());
        } catch (Exception ex) {
            System.out.println("Exception : "+ex);
        }
        System.out.println("Main thread end");
    }
}
