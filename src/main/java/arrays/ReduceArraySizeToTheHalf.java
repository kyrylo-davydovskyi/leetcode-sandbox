package arrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ReduceArraySizeToTheHalf {

    public int minSetSize(int[] arr) {
        var score = new HashMap<Integer, Integer>();
        for (int element : arr) {
            score.merge(element, 1, Integer::sum);
        }

        AtomicInteger counter = new AtomicInteger();
        AtomicInteger currentLength = new AtomicInteger(arr.length);
        score.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(x -> {
                    if (currentLength.get() > arr.length / 2) {
                        currentLength.addAndGet(-x.getValue());
                        counter.getAndIncrement();
                    }
                });
        return counter.get();
    }
}
