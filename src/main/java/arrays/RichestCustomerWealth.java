package arrays;

public class RichestCustomerWealth {

    public int maximumWealth(int[][] accounts) {
        var max = 0;
        for (int[] account : accounts) {
            var temp = 0;
            for(int balance : account) {
                temp += balance;
            }
            if (temp > max)
                max = temp;
        }
        return max;
    }
}
