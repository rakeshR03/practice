package thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantlockTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> new SharedR().produce(lock));
        Thread t2 = new Thread(() -> new SharedR().produce(lock));
        Thread t3 = new Thread(() -> new SharedR().produce(lock));

        t1.start();
        t2.start();
        t3.start();
    }
}
class SharedR {
    static AtomicInteger count = new AtomicInteger(0);

    public void produce(ReentrantLock lock) {
        try {
            lock.lock();
            System.out.println("lock is acquired by : " + Thread.currentThread().getName());

            incrementCount(lock);
        } catch (Exception ex) {
            System.out.println("produce ex; "+ex);
        } finally {
            lock.unlock();
            System.out.println("lock released by " + Thread.currentThread().getName());
        }
    }

    public void incrementCount(ReentrantLock lock) {
        try {
            lock.lock();
            System.out.println("lock acquired in incrementCount by : "+Thread.currentThread().getName());
            System.out.println("En : "+count.incrementAndGet());
        } catch (Exception ex) {
            System.out.println("incrementCount : ex : "+ex);
        } finally {
            lock.unlock();
            System.out.println("lock released in incrementCount by : "+Thread.currentThread().getName());
        }
    }
}
