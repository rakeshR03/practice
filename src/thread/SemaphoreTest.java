package thread;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> new Resource6().produce());
        Thread t2 = new Thread(() -> new Resource6().produce());
        Thread t3 = new Thread(() -> new Resource6().produce());
        Thread t4 = new Thread(() -> new Resource6().produce());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
class Resource6 {
    public static int count = 0;

    Semaphore sem = new Semaphore(2);

    public void produce() {
        try {
            sem.acquire();
            System.out.println("lock acquired by : "+Thread.currentThread().getName());
            for(int i=0; i<4; i++) {
                System.out.println("count : "+count++);
            }
            Thread.sleep(6000);
            sem.release();
            System.out.println("lock released by : "+Thread.currentThread().getName());
        } catch (Exception ex) {

        }
    }
}


