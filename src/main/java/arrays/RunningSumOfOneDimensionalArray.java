package arrays;

public class RunningSumOfOneDimensionalArray {


    /**
     * 1480. Running Sum of 1d Array
     * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
     * Return the running sum of nums.
     * @param nums
     * @return running sum of nums
     */
    public int[] runningSum(int[] nums) {
        var runningSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                runningSum[j] += nums[i];
            }
        }

        return runningSum;
    }
}
