package TargetSum;

public class TargetSum_Memoization {
    static int[][] dp;

    public static int findTargetSumWays(int[] nums, int S) {
        dp = new int[nums.length][2000];
        int res = helper(nums, S, 0, 1000);
        return res;
    }

    private static int helper(int[] nums, int target, int pos, int currSum) {

        if (pos == nums.length) {
            if (currSum - 1000 == target) {
                return 1;
            } else {
                return 0;
            }
        }

        if (dp[pos][currSum] != 0) {
            return dp[pos][currSum];
        } else {
            //At one time we add the number in current sum and one time we subtract the num from the sum and find if sum is 0
            dp[pos][currSum] = helper(nums, target, pos + 1, currSum + nums[pos]) +
                    helper(nums, target, pos + 1, currSum - nums[pos]);
        }

        return dp[pos][currSum];
    }
    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 1,2,3};
        int targetSum = 1;
        int ways = findTargetSumWays(nums,targetSum);
        System.out.println("The number of ways it can be achieved is " + ways);
    }

}
