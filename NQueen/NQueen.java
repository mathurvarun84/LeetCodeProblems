package NQueen;
import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;
public class NQueen {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> output = new ArrayList<>();
        NQueens(board, 0, output);
        return output;
    }

    void NQueens(boolean[][] board, int row, List<List<String>> res) {
        //if row exceeds the board range we will get an answer
        if (row == board.length) {
            ArrayList<String> x = adder(board);
            res.add(x);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col))//check if the current pos is ok to place the queen without attacking other queens
            {
                board[row][col] = true; //marking the pos as true if the queen is placed
                NQueens(board, row + 1, res);
                board[row][col] = false; //this is where backtracking happens we comeback when we are no longer able to move forward
            }
        }

    }

    boolean isSafe(boolean[][] board, int row, int col) {
        //checking the vertical part
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        //checking the left diagonal
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }
        //checking the right diagonal
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }
        //we donot check the lower part cuz we are filling row by row, so by the time we fill a row the below rows will be empty
        return true;
    }

    ArrayList<String> adder(boolean[][] board) {
        ArrayList<String> inner = new ArrayList<>();
        for (boolean[] row : board) {
            StringBuilder s = new StringBuilder();
            for (boolean element : row) {
                if (element) {
                    s.append("Q");
                } else {
                    s.append(".");
                }
            }
            inner.add(s.toString());
        }
        return inner;
    }




    static private void printListOfLists(List<List<String>> listOfLists) {
        System.out.println("\n           List of Lists          ");
        System.out.println("-------------------------------------");
        listOfLists.forEach(innerList -> {
            String line = String.join(", ", innerList);
            System.out.println(line);
        });
    }

    public static void main (String[] args)
    {
        int n = 4;
        NQueen nQueen = new NQueen();
        List<List<String>> listOfNQueens = nQueen.solveNQueens(n);
        printListOfLists(listOfNQueens);
        }
    }


