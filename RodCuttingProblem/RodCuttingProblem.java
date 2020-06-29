package RodCuttingProblem;

public class RodCuttingProblem {
    // A utility function that returns
    // maximum of two integers
    static int max(int a, int b)
    {
        return (a > b) ? a : b;
    }

    // Returns the maximum value that can
    // be put in a knapsack of capacity W
    static int rodCutting(int price[], int n)
    {
        int i, w;
        int K[][] = new int[n + 1][n + 1];
        int length[] = new int[n+1];
        for(int m=0;m<n+1;m++)
        {
            length[m] = m+1;
        }

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= n; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (length[i - 1] <= w)
                    K[i][w] = max(
                            price[i - 1] + K[i][w - length[i - 1]],
                            K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];

                printMatrix(K);
            }
        }

        return K[n][n];
    }


    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 10 && matrix[i][j] > -10) {
                    System.out.print(" ");
                }
                if (matrix[i][j] < 100 && matrix[i][j] > -100) {
                    System.out.print(" ");
                }
                if (matrix[i][j] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


    // Driver program to test above function
    public static void main(String args[])
    {
        int price[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int n = price.length;
        System.out.println(rodCutting(price, n));
    }

}
