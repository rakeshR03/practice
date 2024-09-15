package thread;

public class ByThreadClass {
    public static void main(String[] args) {
        ABC thread1 = new ABC();
        XYZ thread2 = new XYZ();
        thread1.start();
        thread2.start();
    }
}
class ABC extends Thread {

    public void run() {
        for (int i=0; i<5; i++) {
            System.out.println("hi : "+i);
            try{
               Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class XYZ extends Thread {

    public void run() {
        for (int i=0; i<5; i++) {
            System.out.println("hello : "+i);
            try{
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
