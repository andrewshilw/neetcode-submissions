class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i)) {
                return false;
            }
        }

        for (int j = 0; j < 9; j++) {
            if (!isValidCol(board, j)) {
                return false;
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidSub(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidRow(char[][] board, int row) {
        Set<Character> set = new HashSet<>();

        for (int j = 0; j < 9; j++) {
            if (board[row][j] == '.') {
                continue;
            }

            if (set.contains(board[row][j])) {
                return false;
            }

            set.add(board[row][j]);
        }

        return true;
    }

    private boolean isValidCol(char[][] board, int col) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == '.') {
                continue;
            }

            if (set.contains(board[i][col])) {
                return false;
            }

            set.add(board[i][col]);
        }

        return true;
    }

    private boolean isValidSub(char[][] board, int i, int j) {
        Set<Character> set = new HashSet<>();

        for (int s = i; s < i + 3; s++) {
            for (int t = j; t < j + 3; t++) {
                if (board[s][t] == '.') {
                    continue;
                }

                if (set.contains(board[s][t])) {
                    return false;
                }

                set.add(board[s][t]);
            }
        }

        return true;
    }
}
