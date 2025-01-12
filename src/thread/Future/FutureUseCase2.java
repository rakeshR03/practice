package thread.Future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureUseCase2 {
    public static void main(String[] args) {
        System.out.println("Main thread start");
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        // 2nd Use case
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3));
        Future<List<Integer>> futureObj2 = pool.submit(new MyRunnable(list), list);

        pool.shutdown();

        try {
            List<Integer> outputList = futureObj2.get();
            System.out.println("size of output list : "+outputList.size());
            System.out.println("modified size of input list : "+list.size());
        } catch (Exception exception) {
            System.out.println("exception : "+exception);
        }

        System.out.println("Main thread end");
    }
}
class MyRunnable implements Runnable {

    List<Integer> list;

    public MyRunnable(List<Integer> list){
        this.list = list;
    }

    @Override
    public void run() {
        // do something in the list
        System.out.println("Task with Runnable and return object");
        list.add(100);
    }
}

