import java.util.*;

// much more concise
// from other coders
class Solution {
    public static int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        // not removing elements but sorting their differences
        // but may not be sufficient 
        for(int i=stones.length-1; i>0; i--) {
          stones[i-1] = stones[i] - stones[i-1];
          Arrays.sort(stones);
        }
        return stones[0];
      }
}


// class Solution {
//     public int lastStoneWeight(int[] stones) {
//         if (stones == null || stones.length == 0) return 0;
//         Arrays.sort(stones);

//         List<Integer> weight = new ArrayList<>();
//         for (int i = 0; i < stones.length; i++) {
//             weight.add(stones[i]);
//         }

//         while (weight.size() > 1) {
//             int y = weight.get(weight.size() - 1);
//             int x = weight.get(weight.size() - 2);
//             weight.remove(weight.size() - 1);
//             weight.remove(weight.size() - 1);
//             if (x != y) {
//                 int diff = y - x;
//                 if (weight.size() == 0) return diff;
//                 if (diff > weight.get(weight.size() - 1)) weight.add(diff);
//                 else {
//                     for (int i = 0; i < weight.size(); i++) {
//                         if (diff <= weight.get(i)) {
//                             weight.add(i, diff);
//                             break;
//                         }                
//                     }
//                 }
//             } else if (weight.size() == 0) return 0;
        
//             //printList(weight);
//         }
//         return weight.get(0);
//     }

//     // private void printList(List<Integer> list) {
//     //     for (int k : list) System.out.print(k + " ");
//     //     System.out.println();
//     // }
// }