package thread;

public class ByRunnableInterface {
    public static void main(String[] args) {
        Senor man = new Senor();
        Senorita woman = new Senorita();

        //pass obj of runnable interface to thread object
        Thread t1 = new Thread(man);
        Thread t2 = new Thread(woman);

        t1.start();
        t2.start();
    }
}

class Senor implements Runnable {
    @Override
    public void run() {
        for (int i=0; i<5; i++) {
            System.out.println("Senor : "+i);
            try{
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class Senorita implements Runnable {
    @Override
    public void run() {
        for (int i=0; i<5; i++) {
            System.out.println("Senorita : "+i);
            try{
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
