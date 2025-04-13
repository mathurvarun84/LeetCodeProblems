package ContainsDuplicate;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
/*
You are given an integer array nums and two integers indexDiff and valueDiff.

Find a pair of indices (i, j) such that:

i != j,
abs(i - j) <= indexDiff.
abs(nums[i] - nums[j]) <= valueDiff, and
Return true if such pair exists or false otherwise.



Example 1:

Input: nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
Output: true
Explanation: We can choose (i, j) = (0, 3).
We satisfy the three conditions:
i != j --> 0 != 3
abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0
 */
public class ContainsDuplicate {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            Long num = new Long(nums[i]);
            Long floor = set.floor(num);
            Long ceil = set.ceiling(num);

            if (floor != null && Math.abs(floor - num) <= valueDiff) {
                return true;
            }

            if (ceil != null && Math.abs(ceil - num) <= valueDiff) {
                return true;
            }

            set.add(num);

            if (set.size() > indexDiff) {
                set.remove(1L * nums[i - indexDiff]);
            }
        }

        return false;
    }

    public static void main (String[] args) {

        int nums[] = {1,2,3,1,1};
        boolean value= containsNearbyAlmostDuplicate(nums,5,0);
        System.out.println("Value is "+ value);
    }
}
