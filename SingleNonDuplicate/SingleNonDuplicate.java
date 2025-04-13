package SingleNonDuplicate;

/*
 * Given a sorted array of integers where all integers appear twice except for one,
 * find and return the single integer that appears only once.
 * 
 * Example 1:
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * 
 * Example 2:
 * Input: nums = [3,3,7,7,10,11,11]
 * Output: 10
 * 
 * Key insight: In a sorted array with pairs, before the single element,
 * first occurrence is at even index and second at odd index.
 * After the single element, this pattern flips.
 */
public class SingleNonDuplicate {
    
    public static int findSingleElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        // Check edges since we'll be looking at mid-1 and mid+1
        if (nums[0] != nums[1]) return nums[0];
        if (nums[nums.length - 1] != nums[nums.length - 2]) return nums[nums.length - 1];
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Check if mid is the single element
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            
            // If mid is even, its pair should be on right
            // If mid is odd, its pair should be on left
            // Check if this pattern holds to determine which side has the single element
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) ||
                (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                // Pattern is normal on left side, single element must be on right
                left = mid + 1;
            } else {
                // Pattern is disrupted, single element must be on left
                right = mid - 1;
            }
        }
        
        return -1;  // Should never reach here if input is valid
    }
    
    public static void main(String[] args) {
        // Test cases
        int[][] testArrays = {
            {1, 1, 2, 3, 3, 4, 4, 8, 8},          // Single element in middle
            {3, 3, 7, 7, 10, 11, 11},             // Single element near end
            {1, 2, 2, 3, 3},                      // Single element at start
            {1},                                   // Single element array
            {1, 1, 2, 2, 3, 3, 4},                // Single element at end
            {1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 6}    // Single element near end
        };
        
        for (int i = 0; i < testArrays.length; i++) {
            System.out.println("Test Case " + (i + 1) + ":");
            System.out.print("Array: ");
            for (int num : testArrays[i]) {
                System.out.print(num + " ");
            }
            int result = findSingleElement(testArrays[i]);
            System.out.println("\nSingle Element: " + result + "\n");
        }
    }
}
