package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ByExecutorService {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for(int i=0; i<10; i++) {
            service.execute(() -> print(Thread.currentThread().getName()));
        }
        service.shutdown();
    }
    static void print(String thread) {
        for(int i=0; i<5; i++) {
            System.out.println(thread + " : " + i);
            try{
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
