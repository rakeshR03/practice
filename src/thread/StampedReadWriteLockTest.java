package thread;

import java.util.concurrent.locks.StampedLock;

public class StampedReadWriteLockTest {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Thread t1 = new Thread(() -> new Resource().produce());
        Thread t2 = new Thread(() -> new Resource().produce());
        Thread t3 = new Thread(() -> new Resource().consume());

//        Thread t1 = new Thread(() -> resource.produce());
//        Thread t2 = new Thread(() -> resource.produce());
//        Thread t3 = new Thread(() -> resource.consume());

        t1.start();
        t2.start();
        t3.start();
    }
}
class Resource {
    boolean isAvailable = false;
    static StampedLock lock = new StampedLock();

    public void produce() {
        long stamp = lock.readLock();
        try {
            System.out.println("read lock acquired by : "+Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (Exception ex) {

        } finally {
            lock.unlock(stamp);
            System.out.println("read lock release by : "+Thread.currentThread().getName());
        }
    }

    public void consume() {
        long stamp = lock.writeLock();
        try {
            System.out.println("write lock acquired by : "+Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(2000);
        } catch (Exception ex) {

        } finally {
            lock.unlock(stamp);
            System.out.println("write lock is released by : "+Thread.currentThread().getName());
        }
    }
}
