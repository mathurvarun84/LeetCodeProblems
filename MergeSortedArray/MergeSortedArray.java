package MergeSortedArray;

public class MergeSortedArray {

    /**
     * Merge nums2 into nums1 in-place so that nums1 becomes a sorted array.
     *
     * Approach: Two-pointer from the end.
     * - Use three pointers:
     *     i -> last valid element in nums1 (m - 1)
     *     j -> last element in nums2 (n - 1)
     *     k -> last position in nums1 (m + n - 1)
     * - Compare nums1[i] and nums2[j] from the end and place the larger at nums1[k].
     * - Decrement pointers accordingly.
     * - If nums2 has remaining elements, copy them to the front of nums1.
     *
     * Time Complexity: O(m + n)
     * Space Complexity: O(1) - in-place
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        // Merge from the end of the arrays
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If nums2 still has elements, copy them
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    // Simple manual tests
    public static void main(String[] args) {
        MergeSortedArray solver = new MergeSortedArray();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        solver.merge(nums1, 3, nums2, 3);
        // Expected: [1, 2, 2, 3, 5, 6]
        printArray(nums1);

        int[] nums3 = {4, 5, 6, 0, 0, 0};
        int[] nums4 = {1, 2, 3};
        solver.merge(nums3, 3, nums4, 3);
        // Expected: [1, 2, 3, 4, 5, 6]
        printArray(nums3);

        int[] nums5 = {1};
        int[] nums6 = {};
        solver.merge(nums5, 1, nums6, 0);
        // Expected: [1]
        printArray(nums5);

        int[] nums7 = {0};
        int[] nums8 = {1};
        solver.merge(nums7, 0, nums8, 1);
        // Expected: [1]
        printArray(nums7);
    }

    private static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}



