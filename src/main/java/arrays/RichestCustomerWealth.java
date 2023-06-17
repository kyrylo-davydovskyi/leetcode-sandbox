package arrays;

public class RichestCustomerWealth {

    /**
     * 1672. Richest Customer Wealth
     * You are given an m x n integer grid accounts where accounts[i][j] is the amount of money 
     * the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.
     * A customer's wealth is the amount of money they have in all their bank accounts. 
     * The richest customer is the customer that has the maximum wealth.
     * @param accounts
     * @return wealth that the richest customer has
     */
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
