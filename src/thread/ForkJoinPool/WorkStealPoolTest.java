package thread.ForkJoinPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class WorkStealPoolTest {
    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        Future<Integer> futureObj = pool.submit(new ComputeSumTask(1, 10));
        try {
            System.out.println("result : "+futureObj.get());
        } catch (Exception ex) {
            System.out.println("exception : " + ex);
        }
    }
}

class ComputeSumTask extends RecursiveTask<Integer> {
    int start;
    int end;

    ComputeSumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= 4) {
            int totalSum = 0;
            for (int i = start; i <= end; i++) {
                totalSum += i;
            }
            return totalSum;
        } else {
            // split the task
            int mid = (end + start) / 2;
            ComputeSumTask subTask1 = new ComputeSumTask(start, mid);
            ComputeSumTask subTask2 = new ComputeSumTask(mid + 1, end);

            // fork the subtask for parallelism
            subTask1.fork(); // add in work-stealing queue
            subTask2.fork(); // add in work-stealing queue

            // combine the result of subtask
            int leftResult = subTask1.join();
            int rightResult = subTask2.join();

            // combine the result
            return leftResult + rightResult;
        }
    }
}
