package CoinChange;
/*You are given coins of different denominations and a total amount of money amount.
 Write a function to compute the fewest number of coins that you need to make up that amount.
 If that amount of money cannot be made up by any combination of the coins, return -1.

 Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
 */
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]=new int[n+1][amount+1];
        //setting up the base condition
        for(int j=0;j<=amount;j++){
            dp[0][j]=Integer.MAX_VALUE-1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1]<=j)
                    //The addition of +1 is due to the fact that we are using Integer.Max_Value -1
                    //If we don't use it then we end up with Integer.Max_Value+1 which will give negative value
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                else
                    dp[i][j]=dp[i-1][j];
            }
            printMatrix(dp);
        }
        if(dp[n][amount]==Integer.MAX_VALUE-1)
            return -1;
        return dp[n][amount];
    }

    public int coinChangeDp(int[] coins, int amount){
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int amt=1;amt<=amount;amt++){
            int coinNeeded = Integer.MAX_VALUE;
            for(int coin:coins){
                int coinAmountAfterTakingCoin = amt-coin;
                if(coinAmountAfterTakingCoin<0){
                    coinAmountAfterTakingCoin = 0;
                } else {
                    coinAmountAfterTakingCoin = dp[coinAmountAfterTakingCoin]+1;
                }
                if(coinAmountAfterTakingCoin>0){
                    coinNeeded = Math.min(coinNeeded,coinAmountAfterTakingCoin);
                }
            }
            dp[amt]=coinNeeded;
        }
        return dp[amount];
    }

    public static void printIntArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
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


    public static void main(String[] args)
    {
        int[] coins = new int[]{1,2,5};
        int amount = 6;
        System.out.println("The fewest no. of coins " + coinChange(coins,amount));
    }
}
