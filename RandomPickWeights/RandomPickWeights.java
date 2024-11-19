package RandomPickWeights;

import java.util.*;

/*You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.

        You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1] (inclusive) and returns it. The probability of picking an index i is w[i] / sum(w).

        For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%), and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).


        Example 1:

        Input
        ["Solution","pickIndex"]
        [[[1]],[]]
        Output
        [null,0]

        Explanation
        Solution solution = new Solution([1]);
        solution.pickIndex(); // return 0. The only option is to return 0 since there is only one element in w.
*/
public class RandomPickWeights {
    List<Integer> runningSums;
    int totalSum = 0;

    public RandomPickWeights(int[] nums)
    {
        runningSums = new ArrayList<>();
        int runningSum=0;
        for(int num:nums)
        {
            runningSum+=num;
            runningSums.add(runningSum);

        }
        totalSum=runningSum;
    }

    public int pickIndex()
    {
        Random random = new Random();
        int low=0;
        int high = runningSums.size()-1;
        int target = random.nextInt(totalSum);
        while (low<high)
        {
            int mid = low+(high-low)/2;
            if(runningSums.get(mid)>target)
            {
                high = mid;
            }
            else
            {
                low= mid+1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int counter = 900;

        int[][] weights = {
                {1, 2, 3, 4, 5},
                {1, 12, 23, 34, 45, 56, 67, 78, 89, 90},
                {10, 20, 30, 40, 50},
                {1, 10, 23, 32, 41, 56, 62, 75, 87, 90},
                {12, 20, 35, 42, 55},
                {10, 10, 10, 10, 10},
                {10, 10, 20, 20, 20, 30},
                {1, 2, 3},
                {10, 20, 30, 40},
                {5, 10, 15, 20, 25, 30}
        };

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < weights.length; i++) {
            System.out.println((i + 1) + ".\tList of weights: " + Arrays.toString(weights[i]) + ", pick_index() called " + counter + " times" + "\n");
            for (int l = 0; l < weights[i].length; l++) {
                map.put(l, 0);
            }
            RandomPickWeights sol = new RandomPickWeights(weights[i]);
            for (int j = 0; j < counter; j++) {
                int index = sol.pickIndex();
                map.put(index, map.get(index) + 1);
            }
            System.out.println(new String(new char[100]).replace('\0', '-'));
            System.out.println("\t" + String.format("%-10s%-5s%-10s%-5s%-15s%-5s%-20s%-5s%-15s",
                    "Indexes", "|", "Weights", "|", "Occurrences", "|", "Actual Frequency", "|", "Expected Frequency"));
            System.out.println(new String(new char[100]).replace('\0', '-'));
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                System.out.println("\t" + String.format("%-10s%-5s%-10s%-5s%-15s%-5s%-20s%-5s%-15s",
                        key, "|", weights[i][key], "|", value, "|",
                        String.format("%.2f", ((double) value / counter) * 100) + "%", "|",
                        String.format("%.2f", ((double) weights[i][key] / sum(weights[i])) * 100) + "%"));
            }
            map.clear();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

        private static int sum(int[] arr) {
            int total = 0;
            for (int num : arr) {
                total += num;
            }
            return total;
        }
}
