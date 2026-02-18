package kz.seisen.task1;

import java.util.*;
import java.util.concurrent.*;

public class ParallelSumApp {

    public static void main(String[] args) throws Exception {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int N = 2;

        ExecutorService executor = Executors.newFixedThreadPool(N);

        int partSize = numbers.size() / N;
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < N; i++) {

            int start = i * partSize;
            int end = (i == N - 1) ? numbers.size() : start + partSize;

            List<Integer> part = numbers.subList(start, end);

            futures.add(executor.submit(new SumTask(part)));
        }

        int total = 0;

        for (Future<Integer> f : futures) {
            total += f.get();
        }

        executor.shutdown();

        System.out.println("Total: " + total);
    }
}
