import java.util.*;

// a simplified version
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> res = new HashSet<>();
        int sum;
        int remain;
        while (res.add(n)) {
            sum = 0;
            while (n > 0) {
                remain = n % 10;
                sum += remain * remain;
                n = n / 10; // if n =5, n /10 will be 0, break;
            }
            if (sum == 1) return true;
            else n = sum;
        }

        // when do we know an endless loop will occur? when the same n appear again.
        return false;
    }

}


// class Solution {
//     public boolean isHappy(int n) {
//         return helper(n, new ArrayList<Integer>());
//     }

//     private boolean helper(int n, List<Integer> res) {
//         if (n < 1) return false;
//         if (n == 1) return true;

//         int digit = (n + "").length();
//         int sum = 0;
//         for (int i = 0; i < digit; i++) {
//             // current value in this digit
//             int cur = Math.floorMod((int)(n/Math.pow(10, i)), 10);
//             sum += cur * cur;
//         }

//         if (!res.contains(sum)) {
//             res.add(sum);
//             return helper(sum, res);
//         } else {
//             return false;
//         }
              
//     }
// }