package FirstAndLastPositionInSortedArray;

/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
 */
public class FirstAndLastPositionInSortedArray{

        public static int[] searchRange(int[] arr, int target) {
                int start = findPosition(arr, target, false);
                int end = findPosition(arr, target, true);
                return new int[]{start, end};
        }

        private static int findPosition(int[] arr, int target, boolean isLast) {
                int left = 0, right = arr.length-1, index = -1;
                //Do a binary search to find the index.
                while (left <= right) {
                        int mid = left + ((right - left)/2);
                        //If we are searching last position then even if the arr[mid]
                        // is equal to target keep searching
                        if(isLast){
                                if (arr[mid] <= target) left = mid + 1;
                                else right = mid-1;
                        } else{
                                if (arr[mid] < target) left = mid + 1;
                                else right = mid-1;
                        }
                        if(arr[mid] == target) index = mid; /** update index */
                }
                return index;
        }

        // Driver Method
        public static void main(String[] args)
        {
                //Number of pages in books
                int nums[] = new int[]{5,7,7,8,8,10};

                int target = 8; //No. of days

                int[] result = searchRange(nums,target);
                System.out.println("First position is = " + result[0] + " and Last position is =" + result[1]);
        }

}