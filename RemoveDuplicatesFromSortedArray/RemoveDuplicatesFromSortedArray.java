package RemoveDuplicatesFromSortedArray;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class RemoveDuplicatesFromSortedArray {
    /**
     * Remove duplicates in-place from a sorted array.
     * Returns the number of unique elements.
     * 
     * Approach: Two pointers
     * - slow pointer: position for next unique element
     * - fast pointer: iterates through the array
     * 
     * Time Complexity: O(n) where n is the length of nums
     * Space Complexity: O(1)
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int slow = 0; // Position for next unique element
        
        // Iterate through array with fast pointer
        for (int fast = 1; fast < nums.length; fast++) {
            // If we find a new unique element
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        
        // Return number of unique elements (slow + 1)
        return slow + 1;
    }
    
    /**
     * Alternative approach using HashSet (NOT RECOMMENDED for this problem)
     * 
     * Issues:
     * - Uses O(n) extra space (violates in-place requirement)
     * - Requires two passes through the array
     * - Regular HashSet doesn't maintain order (need LinkedHashSet)
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n) - NOT optimal!
     */
    public int removeDuplicatesWithHashSet(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // Use LinkedHashSet to maintain insertion order
        LinkedHashSet<Integer> seen = new LinkedHashSet<>();
        
        // First pass: collect unique elements in order
        for (int num : nums) {
            seen.add(num);
        }
        
        // Second pass: write unique elements back to array
        int index = 0;
        for (int num : seen) {
            nums[index++] = num;
        }
        
        return seen.size();
    }
    
    /**
     * Another HashSet approach - using HashSet to track seen elements
     * Still requires O(n) space and doesn't maintain order efficiently
     */
    public int removeDuplicatesWithHashSetTracking(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        HashSet<Integer> seen = new HashSet<>();
        int writeIndex = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (!seen.contains(nums[i])) {
                seen.add(nums[i]);
                nums[writeIndex++] = nums[i];
            }
        }
        
        return writeIndex;
    }
    
    // Test cases
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        
        // Test case 1: [1,1,2]
        int[] nums1 = {1, 1, 2};
        int k1 = solution.removeDuplicates(nums1);
        System.out.println("Unique elements: " + k1);
        System.out.print("Array after removal: ");
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();
        
        // Test case 2: [0,0,1,1,1,2,2,3,3,4]
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = solution.removeDuplicates(nums2);
        System.out.println("Unique elements: " + k2);
        System.out.print("Array after removal: ");
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println();
        
        // Test case 3: [1,1,1]
        int[] nums3 = {1, 1, 1};
        int k3 = solution.removeDuplicates(nums3);
        System.out.println("Unique elements: " + k3);
        System.out.print("Array after removal: ");
        for (int i = 0; i < k3; i++) {
            System.out.print(nums3[i] + " ");
        }
        System.out.println();
    }
}

