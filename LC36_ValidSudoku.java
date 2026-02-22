package practise.leetCode;


import java.util.HashSet;
import java.util.Set;

public class LC36_ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'.','.','4','.','.','.','6','3','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','9','.'},
                {'.','.','.','5','6','.','.','.','.'},
                {'4','.','3','.','.','.','.','.','1'},
                {'.','.','.','7','.','.','.','.','.'},
                {'.','.','.','5','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'}
        };

        boolean result = isValidSudokuu(board);
        System.out.println("Is the Sudoku board valid? " + result);
    }

    private static boolean isValidSudokuu(char[][] board) {
        Set seen = new HashSet<>();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char number = board[i][j];
                if(number != '.') {
                    if(!seen.add(number + " in row " + i) || !seen.add(number + " in column " + j) ||
                        !seen.add(number + " in box " + i/3 + "-" + j/3)) {
                        return false;
                    }
                }
            }
        }
        System.out.println(seen);
        return true;
    }
}
