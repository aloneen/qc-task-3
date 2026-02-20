package kz.seisen.task1;

import java.util.*;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        int size = 4_000_000;
        List<Integer> list = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            list.add(1);
        }

        int numberOfThreads = 4;
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        List<Future<Long>> futures = new ArrayList<>();

        int partSize = list.size() / numberOfThreads;

        for (int i = 0; i < numberOfThreads; i++) {

            final int start = i * partSize;
            final int end = (i == numberOfThreads - 1) ? list.size() : (i + 1) * partSize;

            List<Integer> part = list.subList(start, end);

            futures.add(executor.submit(() -> {
                long sum = 0;
                for (int n : part) {
                    sum += n;
                }
                return sum;
            }));
        }

        long totalSum = 0;

        try {
            for (Future<Long> future : futures) {
                totalSum += future.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

        System.out.println("Total Sum: " + totalSum);
    }
}