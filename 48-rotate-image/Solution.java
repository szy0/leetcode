class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        if (N <= 1) return;
        
        int base = 0;
        //int n = N/2;
        while ( N >= 1) {    
            for (int i=base; i < N-1 + base; i++) {
                rotateEdge(matrix, base, i);
            }
            N -= 2;
            base += 1;
        }
       
    }

    private void rotateEdge(int[][] matrix, int i, int j) {
        int N = matrix.length;
        int temp = matrix[i][j];

        matrix[i][j] = matrix[N-1-j][i];
        matrix[N-1-j][i] = matrix[N-1-i][N-1-j];
        matrix[N-1-i][N-1-j] = matrix[j][N-1-i];
       

        matrix[j][N-1-i] = temp;
    }

    // private void rotateVertex(int[][] matrix, int k) { // vertex at [k,k] like [0,0] and [1,1]
    //     int N = matrix.length;
    //     int up = matrix[k][k];
    //     int right = matrix[k][N-1-k];
    //     int down = matrix[N-1-k][N-1-k];
    //     int left = matrix[N-1-k][k];

    //     matrix[k][k] = left;
    //     matrix[k][N-1-k] = up;
    //     matrix[N-1-k][N-1-k] = right;
    //     matrix[N-1-k][k] = down;
    // }

}