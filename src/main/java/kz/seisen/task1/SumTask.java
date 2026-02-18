package kz.seisen.task1;

import java.util.List;
import java.util.concurrent.Callable;

public class SumTask implements Callable<Integer> {

    private final List<Integer> numbers;

    public SumTask(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Integer call() {
        int sum = 0;

        for (int n : numbers) {
            sum += n;
        }

        return sum;
    }
}
