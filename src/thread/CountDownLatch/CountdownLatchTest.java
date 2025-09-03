package thread.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountdownLatchTest {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i=0; i<3; i++) {
            service.execute(new MyTask(latch, i));
        }
        service.shutdown();
        try {
            latch.await();
        } catch (Exception ex) {

        }
        System.out.println("main starts now");

    }
}

class MyTask implements Runnable{
    final CountDownLatch latch;
    int count;

    MyTask(CountDownLatch latch, int count) {
        this.latch = latch;
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println("Task:"+count+" is done");
        latch.countDown();
    }
}
