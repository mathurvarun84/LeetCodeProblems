package IPO;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
/*Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.

You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.

Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.

Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.

Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
Output: 4
Explanation: Since your initial capital is 0, you can only start the project indexed 0.
After finishing it you will obtain profit 1 and your capital becomes 1.
With capital 1, you can either start the project indexed 1 or the project indexed 2.
Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
*/
public class IPO {
    public static int maximumCapital(int w, int k, int[] capitals, int[] profits) {
        final int n = profits.length;
        final int[][] projects = new int[n][2];

        for(int i = 0; i < n; ++i) {
            projects[i][0] = capitals[i];
            projects[i][1] = profits[i];
        }

        Arrays.sort(projects,(a, b) -> Integer.compare(a[0], b[0]));

        final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int idx = 0;
        while(k-- > 0) {
            while(idx < n && projects[idx][0] <= w)
                maxHeap.offer(projects[idx++][1]);

            if(maxHeap.isEmpty())
                break;

            w += maxHeap.poll();
        }

        return w;
    }


    public static void main(String[] args) {
        int[] c = { 0, 1, 2, 1, 7, 2 };
        int[] k = { 1, 2, 3, 3, 2, 4 };
        int[][] capitals = {
                {1, 1, 2},
                {1, 2, 2, 3},
                {1, 3, 4, 5, 6},
                {1, 2, 3, 4},
                {6, 7, 8, 10},
                {2, 3, 5, 6, 8, 12}
        };
        int[][] profits = {
                {1, 2, 3},
                {2, 4, 6, 8},
                {1, 2, 3, 4, 5},
                {1, 3, 5, 7},
                {4, 8, 12, 14},
                {1, 2, 5, 6, 8, 9}
        };
        for (int i = 0; i<k.length; i++) {
            System.out.println((i + 1) + ".\tProject capital requirements: " + Arrays.toString(capitals[i]));
            System.out.println("\tProject expected profits: " + Arrays.toString(profits[i]));
            System.out.println("\tNumber of projects: " + k[i]);
            System.out.println("\tStart-up capital: " + c[i]);
            System.out.println("\n\tMaximum Capital earned: " + maximumCapital(c[i], k[i], capitals[i], profits[i]));
           // System.out.println(PrintHyphens.repeat("-", 100));
        }
    }
}
