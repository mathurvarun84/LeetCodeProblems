package PartitionEqualSubsetSum;

import java.util.Arrays;

public class PartitionEqualSubsetSum_BottomUp_Second{
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        sum = Arrays.stream(nums).sum();

        if(sum % 2 != 0) return false;
        //we need half of the sum as if we can reach half of the sum then other half can be in another subset
        int halfOfSum = sum / 2;
        boolean[] dp = new boolean[halfOfSum + 1];
        //Base case as True as the goal is to reach to that sum using numbers and their complements
        dp[halfOfSum] = true;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > halfOfSum) return false;
            //If we have already seen the complement then we can reach to the sum using the number or its complement
            if(dp[nums[i]]) return true;
            //This is to find if we can get to the half sum using numbers which are already there and using its complement
            //For example, if array is [1,2,4,5] we have 4 and we already visited 2 then using 4 and 2 we can reach 6.
            for(int j = 1; j <= halfOfSum; j++){
                if(dp[j] && j - nums[i] > 0) dp[j - nums[i]] = true;
                printBooleanArray(dp);
            }
        }
        return false;
    }

    public static void printBooleanArray(boolean[] array) {
        for (int i = 0; i < array.length; i++) {
            {
                if (array[i]) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }

        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{1,2,4,5};
        boolean result = canPartition(arr);
        System.out.println(result);
    }
}