class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        Set<Integer> rowOfZeroes = new HashSet<>();
        Set<Integer> colOfZeroes = new HashSet<>();

        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowOfZeroes.add(i);
                    colOfZeroes.add(j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowOfZeroes.contains(Integer.valueOf(i))) matrix[i][j] = 0;
                if (colOfZeroes.contains(Integer.valueOf(j))) matrix[i][j] = 0;
            }
        }
        return;

    }
}