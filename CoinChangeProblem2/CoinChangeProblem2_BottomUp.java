package CoinChangeProblem2;
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

public class CoinChangeProblem2_BottomUp {

    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount + 1];
        dp[0][0] = 1;
        for(int i=1;i<=coins.length; i++)
            dp[i][0] = 1;

        for(int i = 1; i <=coins.length; i++){
            for(int j = 1; j <=amount; j++){
                if(coins[i-1] <= j)
                 dp[i][j] = dp[i][j - coins[i-1]] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
            printMatrix(dp);
        }
        return dp[coins.length][amount];
    }

    //Space OptimizationCode
    public static int coinChangeSpaceOptimization(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int x = coin; x < amount + 1; ++x) {
                dp[x] += dp[x - coin];
            }
            printIntArray(dp);
        }
        return dp[amount];
    }


    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 10 && matrix[i][j] > -10) {
                    System.out.print(" ");
                }
                if (matrix[i][j] < 100 && matrix[i][j] > -100) {
                    System.out.print(" ");
                }
                if (matrix[i][j] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printIntArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            {
               System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] coins = new int[]{1,2,3};
        int amount =5;
        System.out.println("The no of ways are " + coinChangeSpaceOptimization(amount,coins));
    }
}
