// a little bit faster (2ms) than my first solution (7ms)
class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
    
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false; // whether first row /column needs to change to zeroes
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i >= 1 && j >= 1) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    } else {
                        firstCol |= (j == 0);
                        firstRow |= (i == 0);
                    }
           
                }
            }
        }
        // i starts from 1 for a reason
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) Arrays.fill(matrix[i], 0);
        }
        // j starts from 1 for a reason 
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // if firstRow/column needs changing
        if (firstRow) Arrays.fill(matrix[0], 0);
        if (firstCol) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        return;

    }
}