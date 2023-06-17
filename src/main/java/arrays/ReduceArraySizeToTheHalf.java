package arrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ReduceArraySizeToTheHalf {

    /**
     * 1338. Reduce Array Size to The Half
     * You are given an integer array arr. You can choose a set of integers and remove 
     * all the occurrences of these integers in the array.
     * Return the minimum size of the set so that at least half of the integers of the array are removed.
     * @param arr
     * @return the minimum size of the set
     */
    public static int minSetSize(int[] arr) {
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
