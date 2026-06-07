package practise.leetCode;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class SumUsingThreads {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Callable<Integer>> tasks = Arrays.asList(
                () -> 10,
                () -> 20,
                () -> 30);

        List<Future<Integer>> results = executor.invokeAll(tasks);

        int sum = 0;
        for (Future<Integer> f : results) {
            sum += f.get();
        }
        System.out.println(sum);
        executor.shutdown();
    }
}
