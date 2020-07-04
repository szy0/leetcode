// an extremely brute-forced solution
// I am surprised that it is accepted.
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int len = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    len = Math.max(len, getSquareLen(matrix, i, j));
                }
            }
        }
        return len * len;
    }

    private int getSquareLen(char[][] matrix, int i, int j) {
        int len = 1;
        while (i + len < matrix.length && j + len < matrix[0].length) {
            for (int ii = i; ii <= i + len; ii++) {
                for (int jj = j; jj <= j + len; jj++) {
                    if (matrix[ii][jj] == '0') {
                        return len;
                    }
                }
            }
            len++;
        }
        return len;
    }
}