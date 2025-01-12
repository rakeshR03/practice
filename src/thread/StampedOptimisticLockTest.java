package thread;

import java.util.concurrent.locks.StampedLock;

public class StampedOptimisticLockTest {
    public static void main(String[] args) {
        Resource4 resource = new Resource4();
        Thread t1 = new Thread(() -> resource.produce());
        Thread t2 = new Thread(() -> resource.consume());

        t1.start();
        t2.start();
    }
}

class Resource4 {
    int a = 10;
    StampedLock lock = new StampedLock();

    public void produce() {
        long stamp = lock.tryOptimisticRead();
        try {
            System.out.println("taken optimistic lock");
            a= 11;
            Thread.sleep(4000);
            if (lock.validate(stamp)) {
                System.out.println("updated successfully");
            } else {
                System.out.println("rollback of work");
//                a = 10; //rollback
            }
            System.out.println("a = "+a);
        } catch (Exception ex) {

        }
    }

    public void consume() {
        long stamp = lock.writeLock();
        try {
            System.out.println("write lock acquired by : " + Thread.currentThread().getName());
            a = 9;
        } catch (Exception ex) {

        } finally {
            lock.unlock(stamp);
            System.out.println("write locked released by : " + Thread.currentThread().getName());
        }
    }
}
