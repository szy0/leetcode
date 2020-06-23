// this solution is from another coder
// start from the top-right of the matrix
// if < target, means target must not in this row as each row is sorted
// if > target, means target must not in this column as each column is sorted

// choosing top-right is very essential, also we can choose bottom-left, but not two other 
// corners. Because choosing top-right and bottom-left,
// the row++ and col-- will shrink the rectangle simultaneously

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] < target) row++;
            else if (matrix[row][col] > target) col--;
            else return true;
        }
        return false;
        
    }
}

   