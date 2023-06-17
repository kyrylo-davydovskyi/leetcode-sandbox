package arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class SlidingWindowMedian {


    /**
     * 480. Sliding Window Median
     * You are given an integer array nums and an integer k. 
     * There is a sliding window of size k which is moving from the very left of the array to the very right. 
     * You can only see the k numbers in the window. 
     * Each time the sliding window moves right by one position.
     * @param nums - array of nums
     * @param k - sliding window
     * @return the median array for each window in the original array
     */    
    //TODO could be improved
    public static double[] medianSlidingWindow(int[] nums, int k) {
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
