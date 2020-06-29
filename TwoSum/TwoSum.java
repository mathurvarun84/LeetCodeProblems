package TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        Example:

        Given nums = [2, 7, 11, 15], target = 9,

        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].*/
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int complement = target - nums[index];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), index };
            }
            map.put(nums[index], index);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{2, 7, 11, 15};
        int target = 22;
        int[] returnedArray = twoSum(arr,target);
        System.out.println(Arrays.toString(returnedArray));
    }
}
