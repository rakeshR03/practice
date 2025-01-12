package thread;

public class SuspendResumeTest {
    public static void main(String[] args) {
        Resource3 resource = new Resource3();

        System.out.println("main thread started");

        Thread t1 = new Thread(() -> {
            resource.produce();
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread2 is sleeping for 1 sec");
            try {
                Thread.sleep(1000);
            } catch (Exception ex){
                System.out.println("ex : "+ex);
            }
            System.out.println("Thread2 is calling produce method");
            resource.produce();
        });
        t1.setDaemon(true);
        t1.start();
        t2.start();

//        try {
//            Thread.sleep(2000);
//        } catch (Exception ex) {
//
//        }
//        t1.suspend();

//        try {
//            Thread.sleep(3000);
//        } catch (Exception ex) {
//
//        }
//        t1.resume();

        System.out.println("main thread ended");
    }
}

class Resource3 {
    boolean isActive = false;

    public synchronized void produce() {
        System.out.println("lock acquired by : "+Thread.currentThread().getName());
        while(!isActive) {
            isActive = true;
        }
        try {
            System.out.println("produce method is sleeping for 5sec ");
            Thread.sleep(5000);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println("lock released by : "+Thread.currentThread().getName());
    }
}
