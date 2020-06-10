import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        //Arrays.sort(costs, (c1, c2) -> Math.abs(c2[1] - c2[0]) - Math.abs(c1[1] - c1[0]));
        Arrays.sort(costs, new Comparator<int[]>() {
            public int compare(int[] c1, int[] c2) {
                return Math.abs(c2[1] - c2[0]) - Math.abs(c1[1] - c1[0]);
            }
        });

        //printCosts(costs);
        int numA = 0, numB = 0;
        int costAll = 0;

        for (int[] cost: costs) {
            if (numA < costs.length/2 && numB < costs.length/2) {
                if (cost[1] < cost[0]) {
                    numB++;
                    costAll += cost[1];
                } else {
                    numA++;
                    costAll += cost[0];
                }
            } else {
                if (numA == costs.length/2) costAll += cost[1];
                if (numB == costs.length/2) costAll += cost[0];
            }
        }
        return costAll;
    }
    // private void printCosts(int[][] costs) {
    //     for (int[] c : costs) {
    //         System.out.println(c[0] + ", " + c[1]);
    //     }
    //     System.out.println();
    // }
}