package MinimumPathSum;

public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        int rows = grid.length;

        if (rows==0) return 0;

        int cols = grid[0].length;

        for(int row =0; row<rows;row++){
            for(int column=0;column<cols;column++){
                if(row==0 && column!=0) grid[row][column] += grid[row][column-1]; // for First Row
                else if (row!=0 && column==0) grid[row][column] += grid[row-1][column]; // for First Column
                 // for Rest of the elements, adds the minimum from the element at top and element at left
                else if(row!=0 && column!=0) grid[row][column] += Math.min(grid[row][column-1], grid[row-1][column]);

            }
            printMatrix(grid);
        }
        return grid[rows-1][cols-1];
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


    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        printMatrix(grid);
        int minimumPathSum = minPathSum(grid);
        System.out.println("The minimum Path sum is " + minimumPathSum);
    }
}
