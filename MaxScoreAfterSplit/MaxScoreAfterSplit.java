package MaxScoreAfterSplit;

public class MaxScoreAfterSplit {

    /**
     * Given a binary string s, split into two non-empty parts (left, right)
     * to maximize: (# of '0' in left) + (# of '1' in right).
     *
     * Idea:
     * - Pre-count total number of '1's in the string.
     * - Iterate split point from index 0 to n-2 (both parts non-empty):
     *   - Maintain count of zeros in the left part.
     *   - Maintain count of ones in the left part.
     *   - Ones in right = totalOnes - onesInLeft.
     *   - Score = zerosInLeft + onesInRight.
     *   - Track maximum score.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int maxScore(String s) {
        int n = s.length();
        if (n < 2) {
            return 0; // no valid split
        }

        // Count total number of '1's
        int totalOnes = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                totalOnes++;
            }
        }

        int zerosInLeft = 0;
        int onesInLeft = 0;
        int maxScore = Integer.MIN_VALUE;

        // Try split after each position from 0 to n-2 (left and right non-empty)
        for (int i = 0; i < n - 1; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                zerosInLeft++;
            } else {
                onesInLeft++;
            }

            int onesInRight = totalOnes - onesInLeft;
            int currentScore = zerosInLeft + onesInRight;

            if (currentScore > maxScore) {
                maxScore = currentScore;
            }
        }

        return maxScore;
    }

    // Simple manual tests
    public static void main(String[] args) {
        MaxScoreAfterSplit solver = new MaxScoreAfterSplit();

        System.out.println(solver.maxScore("011101")); // Expected 5
        System.out.println(solver.maxScore("00111"));  // Expected 5
        System.out.println(solver.maxScore("1111"));   // Expected 3
        System.out.println(solver.maxScore("00"));     // Expected 1
    }
}


