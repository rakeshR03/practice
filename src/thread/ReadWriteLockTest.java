package thread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            new Resource1().produce();
        });

        Thread t2 = new Thread(() -> {
            new Resource1().produce();
        });

        Thread t3 = new Thread(() -> {
            new Resource1().consume();
        });

        t1.start();
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (Exception ex) {

        }

        t3.start();
    }
}
class Resource1 {
    boolean isActive = false;

    static final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void produce() {
        try {
            lock.readLock().lock();
            System.out.println("read lock is acquired by : "+Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (Exception ex) {

        } finally {
            lock.readLock().unlock();
            System.out.println("read lock is released by : "+Thread.currentThread().getName());
        }
    }

    public void consume() {
        try {
            lock.writeLock().lock();
            System.out.println("write lock is acquired by : "+Thread.currentThread().getName());
            isActive = true;
        } catch (Exception ex) {

        } finally {
            lock.writeLock().unlock();
            System.out.println("write lock is released by : "+Thread.currentThread().getName());
        }
    }
}