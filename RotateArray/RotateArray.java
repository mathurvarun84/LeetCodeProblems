package RotateArray;

import java.util.Arrays;

public class RotateArray {
    /**
     * Rotate array to the right by k steps.
     * 
     * Example: [1,2,3,4,5] rotated by k=2 → [4,5,1,2,3]
     */
    
    /**
     * Solution 1: Using Extra Array
     * 
     * Approach:
     * - Create a new array to store rotated elements
     * - Copy elements to their new positions
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public void rotateExtraArray(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return;
        
        k = k % n; // Handle k > n
        
        int[] rotated = new int[n];
        
        // Copy elements to new positions
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }
        
        // Copy back to original array
        System.arraycopy(rotated, 0, nums, 0, n);
    }
    
    /**
     * Solution 2: Reverse Approach (Most Elegant)
     * 
     * Approach:
     * 1. Reverse the entire array
     * 2. Reverse the first k elements
     * 3. Reverse the remaining n-k elements
     * 
     * Example: [1,2,3,4,5], k=2
     * Step 1: Reverse all → [5,4,3,2,1]
     * Step 2: Reverse first 2 → [4,5,3,2,1]
     * Step 3: Reverse last 3 → [4,5,1,2,3] ✓
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void rotateReverse(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return;
        
        k = k % n; // Handle k > n
        
        // Step 1: Reverse entire array
        reverse(nums, 0, n - 1);
        
        // Step 2: Reverse first k elements
        reverse(nums, 0, k - 1);
        
        // Step 3: Reverse remaining elements
        reverse(nums, k, n - 1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    /**
     * Solution 3: Cyclic Replacement
     * 
     * Approach:
     * - Move elements in cycles
     * - Each element moves to position (i + k) % n
     * - Track visited elements to avoid cycles
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void rotateCyclic(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return;
        
        k = k % n;
        int count = 0; // Track number of elements moved
        
        for (int start = 0; count < n; start++) {
            int current = start;
            int prev = nums[start];
            
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current); // Continue until we complete the cycle
        }
    }
    
    /**
     * Solution 3 Alternative: Cyclic Replacement with Visited Array
     * 
     * Approach:
     * - Use boolean array to track visited elements
     * - Simpler logic but uses O(n) space
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public void rotateCyclicWithVisited(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return;
        
        k = k % n;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            
            int current = i;
            int prev = nums[current];
            
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                visited[current] = true;
                current = next;
            } while (current != i);
        }
    }
    
    // Test cases
    public static void main(String[] args) {
        RotateArray solution = new RotateArray();
        
        // Test case 1: [1,2,3,4,5,6,7], k=3
        // Expected: [5,6,7,1,2,3,4]
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums1Copy = Arrays.copyOf(nums1, nums1.length);
        int[] nums1Copy2 = Arrays.copyOf(nums1, nums1.length);
        
        solution.rotateExtraArray(nums1, 3);
        System.out.println("Solution 1 (Extra Array): " + Arrays.toString(nums1));
        // [5, 6, 7, 1, 2, 3, 4]
        
        solution.rotateReverse(nums1Copy, 3);
        System.out.println("Solution 2 (Reverse): " + Arrays.toString(nums1Copy));
        // [5, 6, 7, 1, 2, 3, 4]
        
        solution.rotateCyclic(nums1Copy2, 3);
        System.out.println("Solution 3 (Cyclic): " + Arrays.toString(nums1Copy2));
        // [5, 6, 7, 1, 2, 3, 4]
        
        System.out.println();
        
        // Test case 2: [-1,-100,3,99], k=2
        // Expected: [3,99,-1,-100]
        int[] nums2 = {-1, -100, 3, 99};
        int[] nums2Copy = Arrays.copyOf(nums2, nums2.length);
        int[] nums2Copy2 = Arrays.copyOf(nums2, nums2.length);
        
        solution.rotateExtraArray(nums2, 2);
        System.out.println("Solution 1 (Extra Array): " + Arrays.toString(nums2));
        
        solution.rotateReverse(nums2Copy, 2);
        System.out.println("Solution 2 (Reverse): " + Arrays.toString(nums2Copy));
        
        solution.rotateCyclic(nums2Copy2, 2);
        System.out.println("Solution 3 (Cyclic): " + Arrays.toString(nums2Copy2));
        
        System.out.println();
        
        // Test case 3: [1,2], k=1
        // Expected: [2,1]
        int[] nums3 = {1, 2};
        int[] nums3Copy = Arrays.copyOf(nums3, nums3.length);
        int[] nums3Copy2 = Arrays.copyOf(nums3, nums3.length);
        
        solution.rotateExtraArray(nums3, 1);
        System.out.println("Solution 1 (Extra Array): " + Arrays.toString(nums3));
        
        solution.rotateReverse(nums3Copy, 1);
        System.out.println("Solution 2 (Reverse): " + Arrays.toString(nums3Copy));
        
        solution.rotateCyclic(nums3Copy2, 1);
        System.out.println("Solution 3 (Cyclic): " + Arrays.toString(nums3Copy2));
        
        System.out.println();
        
        // Test case 4: k > n
        int[] nums4 = {1, 2, 3};
        int[] nums4Copy = Arrays.copyOf(nums4, nums4.length);
        int[] nums4Copy2 = Arrays.copyOf(nums4, nums4.length);
        
        solution.rotateExtraArray(nums4, 4); // k=4, n=3, so effectively k=1
        System.out.println("Solution 1 (k=4, n=3): " + Arrays.toString(nums4));
        
        solution.rotateReverse(nums4Copy, 4);
        System.out.println("Solution 2 (k=4, n=3): " + Arrays.toString(nums4Copy));
        
        solution.rotateCyclic(nums4Copy2, 4);
        System.out.println("Solution 3 (k=4, n=3): " + Arrays.toString(nums4Copy2));
    }
}


