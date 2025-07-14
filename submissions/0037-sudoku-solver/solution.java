class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        boolean valid = true;
                        for (int i = 0; i < 9; i++) {
                            if (board[row][i] == c || board[i][col] == c ||
                                board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                                valid = false;
                                break;
                            }
                        }

                        if (valid) {
                            board[row][col] = c;
                            if (solve(board)) return true;
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
