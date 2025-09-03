package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AwaitTerminationTest {
    public static void main(String[] args) {
        System.out.println("Main thread start");
        ExecutorService service = Executors.newFixedThreadPool(2);
        AtomicInteger noOfThread = new AtomicInteger(0);
        for(int i=0; i<3; i++) {
            service.execute(() -> {
                System.out.println("task "+noOfThread.incrementAndGet()+" executed by thread : "+Thread.currentThread().getName());
                try {
                    Thread.sleep(4000);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            });
        }
        service.shutdown();
        try {
            boolean isTerminated = service.awaitTermination(2, TimeUnit.SECONDS);
            System.out.println("is executor service shutdown : " + isTerminated);
        } catch (Exception ex) {
            System.out.println("Exception ex : "+ ex);
        }
        System.out.println("Main thread end");
    }
}
