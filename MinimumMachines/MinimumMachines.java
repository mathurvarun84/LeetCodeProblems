package MinimumMachines;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Given an array of tasks where tasks[i] = [start_i, end_i] represents start and end times,
 * find minimum number of machines needed to complete all tasks.
 * 
 * Constraints:
 * - A machine can execute only one task at a time
 * - A machine can start a new task immediately after completing previous one
 * - Unlimited machines are available
 * 
 * Example:
 * Input: tasks = [[1,4], [2,5], [3,6], [3,7]]
 * Output: 3
 * Explanation: 
 * Machine 1: [1,4]
 * Machine 2: [2,5]
 * Machine 3: [3,6], [7,9]
 */
public class MinimumMachines {
    
    public static int findMinMachines(int[][] tasks) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        
        // Sort tasks by start time
        Arrays.sort(tasks, (a, b) -> a[0] - b[0]);
        
        // Min heap to track end times of tasks running on machines
        PriorityQueue<Integer> machines = new PriorityQueue<>();
        
        int maxMachines = 0;
        
        for (int[] task : tasks) {
            // Remove machines that have completed their tasks
            while (!machines.isEmpty() && machines.peek() <= task[0]) {
                machines.poll();
            }
            
            // Add current task's end time
            machines.offer(task[1]);
            
            // Update maximum machines needed
            maxMachines = Math.max(maxMachines, machines.size());
        }
        
        return maxMachines;
    }
    
    public static void main(String[] args) {
        // Test cases
        int[][][] testCases = {
            {{1, 4}, {2, 5}, {3, 6}, {3, 7}},           // Overlapping tasks
            {{1, 2}, {2, 3}, {3, 4}, {4, 5}},           // Sequential tasks
            {{1, 5}, {1, 5}, {1, 5}, {2, 3}},           // Many overlapping tasks
            {{1, 10}, {2, 7}, {3, 6}, {4, 5}},          // Nested intervals
            {{1, 3}},                                    // Single task
            {}                                           // Empty array
        };
        
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1) + ":");
            System.out.println("Tasks: " + Arrays.deepToString(testCases[i]));
            int result = findMinMachines(testCases[i]);
            System.out.println("Minimum machines needed: " + result);
            System.out.println();
        }
    }
}
