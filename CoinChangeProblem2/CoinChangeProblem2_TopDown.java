package CoinChangeProblem2;

import java.util.Arrays;

/*You are given coins of different denominations and a total amount of money.
Write a function to compute the number of combinations that make up that amount.
 You may assume that you have infinite number of each kind of coin.

Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
*/
public class CoinChangeProblem2_TopDown {

    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int i = 0; i < coins.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return coinChange(coins, 0, amount, dp);
    }

    static int coinChange(int[] coins, int i, int amount, int[][] dp){
        if(amount == 0) return 1;
        if(amount < 0 || i == coins.length) return 0;
        if(dp[i][amount] != -1) return dp[i][amount];

        return dp[i][amount] = coinChange(coins, i, amount - coins[i], dp) + coinChange(coins, i + 1, amount, dp);
    }

    public static void main(String[] args)
    {
        int[] coins = new int[]{1,2,3};
        int amount =5;
        System.out.println("The no of ways are " + change(amount,coins));
    }
}
