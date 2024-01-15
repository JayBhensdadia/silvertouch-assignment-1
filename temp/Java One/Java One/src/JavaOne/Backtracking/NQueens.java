package JavaOne.Backtracking;

public class NQueens {

    public static void print(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
        }
        System.out.println();
    }

    public static boolean isSafe(int row, int col, int[][] board) {
        int n = board.length;

        int i, j;

        // check for the current column
        for (i = row; i >= 0; i--) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // check for upper left diagonal
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // check for upper right diagonal

        for (i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // no danger
        return true;

    }

    public static void helper(int n, int row, int[][] board) {

        if (row >= n) {
            print(board);
            return;
        }

        for (int j = 0; j < n; j++) {

            if (isSafe(row, j, board)) {
                board[row][j] = 1;
                helper(n, row + 1, board);
                board[row][j] = 0;

            }

        }

    }

    public static void placeNQueens(int n) {

        int[][] board = new int[n][n];
        helper(n, 0, board);

    }
}
