// 1, 4, 9, 16... each element we can use multiple times
// we try to add them up to n while keeping the least amount of elements

class Solution {
    // an improved version of my first solution, still slow (700ms)
    public int numSquares(int n) {
        int size = (int)Math.sqrt(n);
        if (size * size == n) return 1; // special case, also make sure no element in list == n

        int[][] dp = new int[size + 1][n + 1];

        for (int j = 1; j <= n; j++) {
            dp[1][j] = j;
        }

        for (int i = 2; i <= size; i++) {
            int num = i * i;
            for (int j = 1; j <= n; j++) {
                if (j >= num) {
                    int m = 1;
                    int min = dp[i-1][j - num * m] + m;

                    while (j >= num * m) { // since a num could be used multiple times, we need to find the min in this case
                        min = Math.min(min,  dp[i-1][j - num * m] + m);
                        m++;
                    }
                    
                    dp[i][j] = Math.min(dp[i-1][j], min);

                } else {
                    dp[i][j] = dp[i-1][j];
                }
                    
            }
        }
        return dp[size][n];
    }
}




    // accepted but very slow (2000ms)

    // public int numSquares(int n) {
    //     List<Integer> squares = new ArrayList<>();
    //     int k = 1;
    //     while (k * k < n) {
    //         squares.add(k * k);
    //         k++;
    //     }
 
    //     if (k * k == n) return 1; // special case, also make sure no element in list == n

    //     int[][] dp = new int[size + 1][n + 1];

    //     for (int j = 1; j <= n; j++) {
    //         dp[1][j] = j;
    //     }

    //     for (int i = 2; i <= size; i++) {
    //         for (int j = 1; j <= n; j++) {
    //             if (j >= squares.get(i-1)) {
    //                 int m = 1;
    //                 int min = dp[i-1][j - squares.get(i-1) * m] + m;

    //                 while (j >= squares.get(i-1) * m) {
    //                     min = Math.min(min,  dp[i-1][j - squares.get(i-1) * m] + m);
    //                     m++;
    //                 }

    //                 dp[i][j] = Math.min(dp[i-1][j], min);

    //             } else {
    //                 dp[i][j] = dp[i-1][j];
    //             }
                    
    //         }
    //     }
    //     return dp[size][n];
    // }