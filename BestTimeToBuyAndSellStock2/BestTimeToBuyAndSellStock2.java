package BestTimeToBuyAndSellStock2;

public class BestTimeToBuyAndSellStock2 {
    /**
     * Find maximum profit by buying and selling stock multiple times.
     * 
     * Key Insight: Since we can buy and sell on the same day and hold at most one share,
     * we should capture every price increase. Whenever price[i+1] > price[i],
     * we can buy on day i and sell on day i+1 to capture the profit.
     * 
     * Approach: Greedy Algorithm
     * - Sum up all positive price differences between consecutive days
     * 
     * Time Complexity: O(n) - single pass through the array
     * Space Complexity: O(1) - only using a few variables
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int maxProfit = 0;
        
        // Capture every price increase
        for (int i = 1; i < prices.length; i++) {
            // If price increases from day i-1 to day i, add the profit
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        
        return maxProfit;
    }
    
    /**
     * Alternative approach: More explicit with same logic
     */
    public int maxProfitAlternative(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int profit = 0;
        int buyPrice = prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            // If price goes up, sell and capture profit
            if (prices[i] > buyPrice) {
                profit += prices[i] - buyPrice;
            }
            // Always update buy price to current price
            // (since we can buy and sell on same day)
            buyPrice = prices[i];
        }
        
        return profit;
    }
    
    /**
     * Peak Valley Approach: Buy at valleys, sell at peaks
     * This is more intuitive but less efficient
     */
    public int maxProfitPeakValley(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int i = 0;
        int maxProfit = 0;
        int valley = prices[0];
        int peak = prices[0];
        
        while (i < prices.length - 1) {
            // Find valley (local minimum)
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            
            // Find peak (local maximum)
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            
            // Add profit from this valley-peak pair
            maxProfit += peak - valley;
        }
        
        return maxProfit;
    }
    
    // Test cases
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock2 solution = new BestTimeToBuyAndSellStock2();
        
        // Test case 1: [7,1,5,3,6,4]
        // Buy on day 2 (1), sell on day 3 (5) -> profit 4
        // Buy on day 4 (3), sell on day 5 (6) -> profit 3
        // Total: 7
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Test 1: " + solution.maxProfit(prices1)); // 7
        
        // Test case 2: [1,2,3,4,5]
        // Buy on day 1 (1), sell on day 5 (5) -> profit 4
        // Or: Buy-sell every day: (2-1)+(3-2)+(4-3)+(5-4) = 4
        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("Test 2: " + solution.maxProfit(prices2)); // 4
        
        // Test case 3: [7,6,4,3,1]
        // No profit possible (prices only decrease)
        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println("Test 3: " + solution.maxProfit(prices3)); // 0
        
        // Test case 4: [3,3,5,0,0,3,1,4]
        // Multiple buy-sell opportunities
        int[] prices4 = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println("Test 4: " + solution.maxProfit(prices4)); // 8
        // Explanation: (5-3) + (3-0) + (4-1) = 2 + 3 + 3 = 8
        
        // Test case 5: Single day
        int[] prices5 = {1};
        System.out.println("Test 5: " + solution.maxProfit(prices5)); // 0
    }
}



