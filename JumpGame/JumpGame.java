package JumpGame;

public class JumpGame {

    /**
     * Jump Game: return true if we can reach the last index.
     *
     * Greedy approach (from right to left):
     * - Maintain the leftmost position that can reach the end (`goodPos`).
     * - Iterate from end to start; if index + nums[i] >= goodPos, then goodPos = i.
     * - At the end, we can reach the end if goodPos == 0.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean canJump(int[] nums) {
        int goodPos = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goodPos) {
                goodPos = i;
            }
        }

        return goodPos == 0;
    }

    /**
     * Forward greedy variant:
     * Track the furthest reachable index while scanning from left to right.
     * If at any point the current index is beyond the furthest reachable, return false.
     */
    public boolean canJumpForward(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                return false; // can't reach this position
            }
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= nums.length - 1) {
                return true; // early exit when end is reachable
            }
        }
        return true;
    }

    // Simple manual tests
    public static void main(String[] args) {
        JumpGame solver = new JumpGame();

        int[] nums1 = {2, 3, 1, 1, 4}; // true
        int[] nums2 = {3, 2, 1, 0, 4}; // false
        int[] nums3 = {0};             // true (already at last index)
        int[] nums4 = {2, 0, 0};       // true
        int[] nums5 = {1, 1, 0, 1};    // false

        System.out.println(solver.canJump(nums1)); // true
        System.out.println(solver.canJump(nums2)); // false
        System.out.println(solver.canJump(nums3)); // true
        System.out.println(solver.canJump(nums4)); // true
        System.out.println(solver.canJump(nums5)); // false
    }
}



