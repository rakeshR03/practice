package thread.Future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureUseCase3 {
    public static void main(String[] args) {
        System.out.println("Main thread start");
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        // 3rd Use case
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3));
        Future<List<Integer>> futureObj2 = pool.submit(() -> {
            System.out.println("Task with callable");
            list.add(100);
            return list;
        });

        pool.shutdown();
        try {
            List<Integer> outputList = futureObj2.get();
            System.out.println("size of output list : "+outputList.size());
        } catch (Exception exception) {
            System.out.println("exception : "+exception);
        }

        System.out.println("Main thread end");
    }
}
