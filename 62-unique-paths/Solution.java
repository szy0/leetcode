import java.math.BigInteger;

// actually a combination problem
// C _(m + n -2) ^(m - 1)
// from (m + n -2)  choose (m - 1)

class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        if (m == 1 || n == 1) return 1;
    
        int stepOfRight = m - 1;
        int stepOfDown = n - 1; 
        int steps = stepOfRight + stepOfDown;

        if (m > n) 
            return combination(steps, stepOfDown);
        else 
            return combination(steps, stepOfRight);
    }

    // CnK
    private int combination(int n, int k) {
        int i = n;
        int m = k;

        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;

        while (i >= n-k+1) a = a.multiply(BigInteger.valueOf(i--));
        while (m >= 1) b = b.multiply(BigInteger.valueOf(m--));

        return a.divide(b).intValue();
    }
}