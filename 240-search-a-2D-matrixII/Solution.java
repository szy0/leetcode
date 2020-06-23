class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int row = findRowIndex(matrix, target);
        if (row == -1) {
            //System.out.println("no row!");
            return false;
        } else {
            //System.out.println("row " + row);
            while (row >= 0 && findColIndex(matrix, target, row) == -1) {
                row--;
            } 
            return row < 0 ? false : true;
        }
    }

    private int findRowIndex(int[][] matrix, int target) {
        int low = 0, high = matrix.length - 1;
        if (matrix[low][0] > target || matrix[high][matrix[high].length - 1] < target) return -1;

        int mid = (low + high)/2;
        while (low < high) {
            if (matrix[mid + 1][0] <= target) low = mid + 1;
            else if (matrix[mid][0] >= target) high = mid;
            else return mid;
            mid = (low + high)/2;
        }
        return low;
    }

    private int findColIndex(int[][] matrix, int target, int row) {
        int[] num = matrix[row];
        int left = 0, right = num.length - 1;
        int mid = (left + right)/2;
        while (left <= right) {
            if (num[mid] < target) left = mid + 1;
            else if (num[mid] > target) right = mid - 1;
            else return mid;
            mid = (left + right)/2;
        }
        return -1;
    }
}