class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int low = 0;
        int high = matrix[0].length * matrix.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high)/2;
            if (getValue(matrix, mid) < target) low = mid + 1;
            else if (getValue(matrix, mid) > target) high = mid - 1;
            else return true;
        }
        return false;
    }

    private int getValue(int[][] matrix, int n) {
        n++; // n should start from 1, means the amount of numbers
        int len = matrix[0].length;
        int col = 0, row = 0; // col and row are "real" index
        if (n % len == 0) {
            col = len - 1;
            row = n / len - 1;
        } else {
            col = n % len - 1;
            row = (n - col)/len;
        }
        return matrix[row][col];
    }

}