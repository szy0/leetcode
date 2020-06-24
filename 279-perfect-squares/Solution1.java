// from another coder
// this solution is 1D DP array, saving more time and space than my 2D DP array

// another difference is that we distract differently from current number
// (notice how i,j have different meanings in these two solutions)

// e.g. n = 18, 18 = 16 + 1 + 1 = 9 + 9 obviously the result is 2
// my solution is that dp[i][18] is the min {only use 1,4,9 but not 16 | use 16 once | use 16 twice | use 16 three times...}
// this solution dp[18] is min {dp[17] + 1, dp[14] + 1, dp[9] + 1, dp[2] + 1}


// e.g. n = 34, 34 = 25 + 9 result is 2
// my solution is that dp[i][34] is the min {only use 1,4,9,16 but not 25 | use 25 once | use 25 twice |...}
// this solution dp[34] is min {dp[33] + 1, dp[30] + 1, dp[25] + 1, dp[18] + 1, dp[9] + 1}

// this solution always distract a perfect square from current number, then it always only need "+ 1"
// therefore one part is always perfect square "+1", another part (dp[33], dp[30] ...) already stores the min num of squares
// brilliant!

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // least num of Squares for values from (0) 1,2,3...n
        for (int i = 1; i <= n; i++) {
            int j = 1;
            dp[i] = n; 
            // initialize dp[i] to be a large number (just a upper limit), also we can dp[i] = Integer.MAX_VALUE
            // since n would be the largest possible number in the whole dp array, we can choose n
            // also we can let dp[i] = i;
            while (i - j * j >= 0) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
                j++;
            }
        }
        return dp[n];
    }
}