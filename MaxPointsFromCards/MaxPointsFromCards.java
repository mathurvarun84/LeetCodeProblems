package MaxPointsFromCards;

public class MaxPointsFromCards {

    /**
     * Given cardPoints and k, returns the maximum score by picking exactly k cards
     * from either end of the array.
     *
     * Idea:
     * - Instead of choosing k cards to take, think of choosing n - k consecutive cards to leave.
     * - Total sum of all cards - minimum sum of any subarray of length (n - k) gives the answer.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        // If we take all cards
        if (k >= n) {
            int total = 0;
            for (int point : cardPoints) {
                total += point;
            }
            return total;
        }

        int windowSize = n - k; // size of subarray to leave

        // Compute total sum and initial window sum
        int totalSum = 0;
        int windowSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += cardPoints[i];
            if (i < windowSize) {
                windowSum += cardPoints[i];
            }
        }

        int minWindowSum = windowSum;

        // Slide the window of size windowSize across the array
        for (int right = windowSize; right < n; right++) {
            windowSum += cardPoints[right];                 // add new element to window
            windowSum -= cardPoints[right - windowSize];    // remove element leaving window
            minWindowSum = Math.min(minWindowSum, windowSum);
        }

        // Maximum score is totalSum - minimum sum of subarray we leave
        return totalSum - minWindowSum;
    }

    // Simple manual tests
    public static void main(String[] args) {
        MaxPointsFromCards solver = new MaxPointsFromCards();

        int[] cards1 = {1, 2, 3, 4, 5, 6, 1};
        System.out.println(solver.maxScore(cards1, 3)); // Expected 12

        int[] cards2 = {2, 2, 2};
        System.out.println(solver.maxScore(cards2, 2)); // Expected 4

        int[] cards3 = {9, 7, 7, 9, 7, 7, 9};
        System.out.println(solver.maxScore(cards3, 7)); // Expected 55

        int[] cards4 = {1, 1000, 1};
        System.out.println(solver.maxScore(cards4, 1)); // Expected 1000
    }
}


