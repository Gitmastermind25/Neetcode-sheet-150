package arraysandhashing;

import java.util.*;

public class ValidSudoku {

    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            boolean[][] row = new boolean[9][9];
            boolean[][] col = new boolean[9][9];
            boolean[][] box = new boolean[9][9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') continue;

                    int digit = board[i][j] - '0' - 1;
                    int boxIndex = (i / 3) * 3 + (j / 3);

                    if (row[i][digit] || col[j][digit] || box[boxIndex][digit]) {
                        return false;
                    }

                    row[i][digit] = true;
                    col[j][digit] = true;
                    box[boxIndex][digit] = true;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[9][9];

        System.out.println("Enter Sudoku board (9 rows, use '.' for empty):");

        for (int i = 0; i < 9; i++) {
            String rowInput = sc.next();
            for (int j = 0; j < 9; j++) {
                board[i][j] = rowInput.charAt(j);
            }
        }

        Solution sol = new Solution();
        boolean result = sol.isValidSudoku(board);

        if (result) {
            System.out.println("Valid Sudoku");
        } else {
            System.out.println("Invalid Sudoku");
        }

        sc.close();
    }
}