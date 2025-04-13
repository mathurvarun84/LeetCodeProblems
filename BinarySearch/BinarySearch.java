package BinarySearch;

/*
 * Given an array of integers nums which is sorted in ascending order, and a target integer,
 * write a function to search target in nums. If target exists, return its index. Otherwise, return -1.
 * 
 * Example 1:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * 
 * Example 2:
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 */
public class BinarySearch {
    
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;  // Avoid potential integer overflow
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        // Test cases
        int[][] testArrays = {
            {-1, 0, 3, 5, 9, 12},
            {-1, 0, 3, 5, 9, 12},
            {1},
            {1, 2, 3, 4, 5},
            {}
        };
        
        int[] targets = {9, 2, 1, 6, 5};
        
        for (int i = 0; i < testArrays.length; i++) {
            System.out.println("Test Case " + (i + 1) + ":");
            System.out.print("Array: ");
            for (int num : testArrays[i]) {
                System.out.print(num + " ");
            }
            System.out.println("\nTarget: " + targets[i]);
            int result = search(testArrays[i], targets[i]);
            System.out.println("Result: " + result + "\n");
        }
    }
}
