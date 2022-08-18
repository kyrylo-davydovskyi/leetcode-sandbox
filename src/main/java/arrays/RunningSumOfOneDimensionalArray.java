package arrays;

public class RunningSumOfOneDimensionalArray {
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
