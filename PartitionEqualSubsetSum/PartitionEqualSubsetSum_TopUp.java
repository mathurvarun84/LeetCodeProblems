package PartitionEqualSubsetSum;

public class PartitionEqualSubsetSum_TopUp{
    // A utility function that returns true if there is a
    // subset of arr[] with sun equal to given sum
    static Boolean[][] dp;
    static boolean isSubsetSum (int nums[], int low, int high, int sum)
    {
        // Base Cases
        if (sum == 0)
            return true;
        if(sum < 0 || low > high) return false;

        if(dp[high][sum] != null) return dp[high][sum];

        // If last element is greater than sum, then ignore it
        if (nums[high] > sum)
            return isSubsetSum (nums, low, high-1, sum);

        /* else, check if sum can be obtained by any of
           the following
        (a) including the last element
        (b) excluding the last element
        */
        dp[high][sum] = isSubsetSum (nums, low,high-1, sum) ||
                isSubsetSum (nums, low, high-1, sum-nums[high]);
        return dp[high][sum];
    }

    // Returns true if arr[] can be partitioned in two
    // subsets of equal sum, otherwise false
    static boolean canPartition (int[] nums)
    {
        // Calculate sum of the elements in array
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];

        // If sum is odd, there cannot be two subsets
        // with equal sum
        if (sum%2 != 0)
            return false;

        // Find if there is subset with sum equal to half
        // of total sum
        int half_sum = sum/2;
        dp = new Boolean[nums.length+1][half_sum+1];
        return isSubsetSum (nums,0, nums.length-1, sum/2);
    }

    /*Driver function to check for above function*/


    public static void main (String[] args)
    {

        int arr[] = {1,2,4,5};
        if (canPartition(arr) == true)
            System.out.println("Can be divided into two "+
                    "subsets of equal sum");
        else
            System.out.println("Can not be divided into " +
                    "two subsets of equal sum");
    }

}