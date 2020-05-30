import java.util.ArrayList;
import java.util.TreeMap;

// this solution by myself is straight-forward. It works, but not quite fast
// takes 40ms

class Solution {


    // a concise, beautiful solution from another coder
    // this solution is slow: 104ms
    // also, another disadvantage is that this solution changes the original array

    // public int[][] kClosest(int[][] points, int K) {
    //     Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
    //     return Arrays.copyOfRange(points, 0, K);
    // }


    public int[][] kClosest(int[][] points, int K) {
        TreeMap<Integer, ArrayList<int[]>> sorted = new TreeMap<>();
        int[][] res = new int[K][2];
        for (int[] point : points) {
            // since x,y of points are integer, we can use integer to represent distance
            int distance = point[0]*point[0] + point[1]*point[1];
            if (sorted.containsKey(distance)) {
                sorted.get(distance).add(point);
                // note that every (x,y) is unique, so it does not matter if Set 
                // cannot tell from arrays
            } else {
                ArrayList<int[]> list = new ArrayList<>();
                list.add(point);
                sorted.put(distance, list);
            }
            
        }

        Iterator<Map.Entry<Integer, ArrayList<int[]>>> it = sorted.entrySet().iterator();
        int i = 0;
        while (i < K) {
            ArrayList<int[]> list = it.next().getValue();
            int num = list.size();
            for (int j = i; j < i + num; j++) {
                res[j] = list.get(j-i);
                if (j == K-1) {
                    return res;
                }
            }
           
            i += num;
        }
           
        return res;
    }
}