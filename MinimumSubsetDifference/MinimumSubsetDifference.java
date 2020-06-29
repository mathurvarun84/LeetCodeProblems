package MinimumSubsetDifference;

import java.util.Arrays;

public class MinimumSubsetDifference {

    // Returns the minimum value of
    //the difference of the two sets.
    static int findMin(int arr[], int n)
    {
        // Calculate sum of all elements
        int sum = 0;
        sum = Arrays.stream(arr).sum();

        // Create an array to store
        // results of subproblems
        boolean dp[][] = new boolean[n + 1][sum + 1];

        // Initialize first column as true.
        // 0 sum is possible  with all elements.
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        // Initialize top row, except dp[0][0],
        // as false. With 0 elements, no other
        // sum except 0 is possible
        for (int i = 1; i <= sum; i++)
            dp[0][i] = false;

        // Fill the partition table
        // in bottom up manner
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= sum; j++)
            {
                // If i'th element is included
                if (j>=arr[i - 1])
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                else
                    // If i'th element is excluded
                    dp[i][j] = dp[i - 1][j];

                printBooleanMatrix(dp, sum,n);
            }
        }

        // Initialize difference of two sums.
        int diff = Integer.MAX_VALUE;

        // Find the minimum diff such that dp[n][j]
        // is true where j loops from sum/2 t0 0
        for (int j = sum / 2; j >= 0; j--)
        {
            // Find the
            if (dp[n][j] == true)
            {
                diff = Math.min(diff,sum - 2 * j);
            }
        }
        return diff;
    }

    public static void printBooleanMatrix(boolean[][] array,int sum, int n) {
        for (int i = 0; i <= n; i++) {
            {
                for(int j=0;j<=sum;j++) {
                    if (array[i][j]) {
                        System.out.print("1");
                    } else {
                        System.out.print("0");
                    }
                }
                System.out.println();
            }

        }
        System.out.println();
    }


    // Driver program
    public static void main (String[] args)
    {
        int arr[] = {1, 2, 1};
        int n = arr.length;
        System.out.println ("The minimum difference between 2 sets is "
                + findMin(arr, n));

    }

}
