package arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class SlidingWindowMedian {

    //TODO could be improved
    public double[] medianSlidingWindow(int[] nums, int k) {
        log.info("Recieved array {}", nums);
        var result = new double[nums.length - k + 1];
        boolean odd = k % 2 > 0;
        int medianIndexDown = k / 2;
        log.info("k/2 = {}", medianIndexDown);
        for(int i = 0; i < nums.length - k + 1; i++) {
            var segment = Arrays.copyOfRange(nums, i, i+k);
            Arrays.sort(segment);
            log.info("Ordered segment {}. Segment started from {} element of source array", segment, i);
            if (odd) {
                log.info("result[{}] = {}", i, segment[medianIndexDown]);
                result[i] = segment[medianIndexDown];
            }
            else {
                result[i] = ((double) segment[medianIndexDown] + (double) segment[medianIndexDown - 1]) / 2;
                log.info("result[{}] = ({} + {}) / 2 = {}", i, segment[medianIndexDown], segment[medianIndexDown - 1], result[i]);
            }
        }
        return result;
    }
}
