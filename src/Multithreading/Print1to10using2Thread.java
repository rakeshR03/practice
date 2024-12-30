package Multithreading;

public class Print1to10using2Thread {
    public static void main(String[] args) {
        SharedResource1 sharedResource1 = new SharedResource1(1, 10);
        Helper t1 = new Helper(sharedResource1, 0);
        Helper t2 = new Helper(sharedResource1, 1);
        Helper t3 = new Helper(sharedResource1, 2);

        t1.start();
        t2.start();
        t3.start();

    }
}

class SharedResource1 {
    int count;
    int max;

    public SharedResource1(int count, int max) {
        this.count = count;
        this.max = max;
    }
    public synchronized void incrementCount(int thread) {
        try {
            while(this.count < this.max) {
                while (this.count % 3 != thread) {
                    wait();
                }
                if (this.count <= this.max) {
                    System.out.println(Thread.currentThread().getName() + " : " + this.count++);
                }
                notifyAll();
            }
        } catch (Exception exception) {
            System.out.println("exception : " + exception.getMessage());
        }
    }
}

class Helper extends Thread {
    SharedResource1 sharedResource1;
    int thread;

    public Helper(SharedResource1 sharedResource1, int thread) {
        this.sharedResource1 = sharedResource1;
        this.thread = thread;
    }
    @Override
    public void run() {
        sharedResource1.incrementCount(this.thread);
    }
}
