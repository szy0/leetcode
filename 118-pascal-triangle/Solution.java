import java.util.Arrays;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows == 0) return res;
        
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        res.add(row1);
        if (numRows == 1) return res;
     
        for (int i = 2; i <= numRows; i++) {
            Integer[] tmp = new Integer[i];
            tmp[0] = 1;
            tmp[i-1] = 1;
            for (int j = 1; j <= i-2; j++) {
                tmp[j] = res.get(i-2).get(j-1) + res.get(i-2).get(j);
            }
            //List<Integer> curRow = Arrays.asList(tmp);
            res.add(Arrays.asList(tmp));
        }
        return res;

    }
}