package GasStation;

public class GasStation {
    /**
     * Find the starting gas station index to complete a circular route.
     * 
     * Approach: Greedy Algorithm
     * Key Insights:
     * 1. If total gas < total cost, it's impossible to complete the circuit
     * 2. If we start at station i and run out of gas at station j, 
     *    then any station between i and j cannot be a valid starting point
     * 3. We can track the current gas and reset when it goes negative
     * 
     * Time Complexity: O(n) - single pass through the array
     * Space Complexity: O(1) - only using a few variables
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        
        // Check if total gas is sufficient
        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        
        // If total gas < total cost, impossible to complete circuit
        if (totalGas < totalCost) {
            return -1;
        }
        
        // Greedy approach: find the starting point
        int startIndex = 0;
        int currentGas = 0;
        
        for (int i = 0; i < n; i++) {
            // Net gain/loss at station i
            currentGas += gas[i] - cost[i];
            
            // If current gas becomes negative, we can't reach station i+1
            // So we reset and try starting from station i+1
            if (currentGas < 0) {
                startIndex = i + 1;
                currentGas = 0;
            }
        }
        
        return startIndex;
    }
    
    /**
     * Alternative approach: More explicit greedy with same logic
     */
    public int canCompleteCircuitAlternative(int[] gas, int[] cost) {
        int n = gas.length;
        int totalSurplus = 0;
        int currentSurplus = 0;
        int startIndex = 0;
        
        for (int i = 0; i < n; i++) {
            int surplus = gas[i] - cost[i];
            totalSurplus += surplus;
            currentSurplus += surplus;
            
            // If we can't reach station i+1, reset
            if (currentSurplus < 0) {
                startIndex = i + 1;
                currentSurplus = 0;
            }
        }
        
        // If total surplus >= 0, there exists a solution
        return totalSurplus >= 0 ? startIndex : -1;
    }
    
    // Test cases
    public static void main(String[] args) {
        GasStation solution = new GasStation();
        
        // Test case 1: [1,2,3,4,5], [3,4,5,1,2]
        // Expected: 3
        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};
        System.out.println("Test 1: " + solution.canCompleteCircuit(gas1, cost1)); // 3
        
        // Test case 2: [2,3,4], [3,4,3]
        // Expected: -1
        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};
        System.out.println("Test 2: " + solution.canCompleteCircuit(gas2, cost2)); // -1
        
        // Test case 3: [5,1,2,3,4], [4,4,1,5,1]
        // Expected: 4
        int[] gas3 = {5, 1, 2, 3, 4};
        int[] cost3 = {4, 4, 1, 5, 1};
        System.out.println("Test 3: " + solution.canCompleteCircuit(gas3, cost3)); // 4
        
        // Test case 4: [1,1,1], [2,2,2]
        // Expected: -1
        int[] gas4 = {1, 1, 1};
        int[] cost4 = {2, 2, 2};
        System.out.println("Test 4: " + solution.canCompleteCircuit(gas4, cost4)); // -1
    }
}



