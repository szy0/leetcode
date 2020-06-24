// mainly based on solution1
// I guess leetcode only new Solution() once, then call numSquares() many times
// so we can store the calculation in the global variable list to save time

class Solution {
    private List<Integer> list = new ArrayList<>(); // replace dp[], storing results for (0),1,2,3,...n
    public int numSquares(int n) {
        if (list.size() == 0) list.add(0); // initialize
        if (list.size() > n) return list.get(n); // already calculated

        for (int i = list.size(); i <= n; i++) { // continue from last calculation
            int j = 1;
            int res = i;
      
            while (i - j * j >= 0) {
                res = Math.min(list.get(i - j*j) + 1, res);
                j++;
            }
            list.add(res);
        }
        return list.get(n); // last value
    }
}