import java.util.*;

class Solution {
    // this method works, but only for sorted intervals
    public int[][] merge(int[][] intervals) {
        int amount = intervals.length;
        if (amount <= 1) return intervals;
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));


        List<Integer[]> copy = new ArrayList<>();
        for (int[] pair : intervals) {
            copy.add(new Integer[]{pair[0], pair[1]});
        }

        for (int k = 0; k <= amount - 2; k++) {
            if (copy.get(k)[1] >= copy.get(k+1)[0]) {
                if (copy.get(k)[1] <= copy.get(k+1)[1]) {
                    copy.get(k)[1] = copy.get(k+1)[1];
                }
                copy.remove(k+1);
                k--;
                amount--;
            }
        }

        int[][] res = new int[copy.size()][2];
        for (int m = 0; m < copy.size(); m++) {
            res[m] = new int[]{copy.get(m)[0], copy.get(m)[1]};
        }
        return res;

    }

    
}