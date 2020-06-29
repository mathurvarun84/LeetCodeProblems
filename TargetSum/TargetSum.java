package TargetSum;

public class TargetSum {
    /*The original problem statement is equivalent to:
Find a subset of nums that need to be positive, and the rest of them negative, such that the sum is equal to target

Let P be the positive subset and N be the negative subset
For example:
Given nums = [1, 2, 3, 4, 5] and target = 3 then one possible solution is +1-2+3-4+5 = 3
Here positive subset is P = [1, 3, 5] and negative subset is N = [2, 4]

Then let's see how this can be converted to a subset sum problem:

                  sum(P) - sum(N) = target
sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
                       2 * sum(P) = target + sum(nums)
So the original problem has been converted to a subset sum problem as follows:
Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2
     */

    public static int findTargetSumWaysUsing1D(int[] nums, int S) {
        int sum = 0;
        S = Math.abs(S);
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        // Invalid S, just return 0
        if (S > sum || (sum + S) % 2 != 0)
            return 0;
        //We need to achieve the target
        int target = (sum + S) / 2;

        int dp[] = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
            printIntArray(dp);
        }
        return dp[target];
    }

    public static void printIntArray(int[] array)
    {
        for(int i=0;i<array.length;i++)
            System.out.print(array[i] + " ");
        System.out.println("");
    }

    public static int findTargetSumWaysUsing2D(int[] nums, int S) {
        int sum = 0;
        S = Math.abs(S);
        for(int i = 0; i < nums.length; i++)
            sum += nums[i];
        // Invalid S, just return 0
        if( S > sum || (sum + S) % 2 != 0 )
            return 0;

        int target = (sum + S) / 2;
        int dp[][] = new int[(target + 1)][nums.length + 1];
        dp[0][0] = 1;
        for(int i = 0; i < nums.length; i++) { // empty knapsack must be processed specially
            if( nums[i] == 0 )
                dp[0][i + 1] = dp[0][i] * 2;
            else
                dp[0][i + 1] = dp[0][i];
        }
        printMatrix(dp);
        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                dp[i][j + 1] += dp[i][j];
                if( nums[j] <= i )
                    dp[i][j + 1] += dp[i - nums[j]][j];
                printMatrix(dp);
            }
            printMatrix(dp);
        }
        return dp[(sum + S) / 2][nums.length];
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
        int[] nums = new int[]{1, 1,2,3};
        int targetSum = 1;
        int ways = findTargetSumWaysUsing2D(nums,targetSum);
        System.out.println("The number of ways it can be achieved is " + ways);
    }
}
