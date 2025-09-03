package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShutDownNow {
    public static void main(String[] args) {
        System.out.println("main thread start");
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(() -> {
            try {
                Thread.sleep(10000);
            } catch (Exception ex) {
                System.out.println("exception : " + ex);
            }
        });

        service.shutdownNow();
        System.out.println("main thread end");
    }
}
