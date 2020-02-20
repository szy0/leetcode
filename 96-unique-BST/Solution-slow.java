class Solution {
    public int numTrees(int n) {
        if (n <= 1) return 1;
        return countTrees(1, n);
        
    }

    private int countTrees(int left, int right) {
        int res = 0;
        for (int index = left; index <= right; index++) {
            int num1 = numTrees(index - left);
            int num2 = numTrees(right - index);
            if (num1 <= 1) res += num2;
            else 
                if (num2 <= 1) res += num1;
            else
                res += num1 * num2;
        }
        return res;
       
    }
}