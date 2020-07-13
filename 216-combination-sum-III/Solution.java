// two different backtracking approaches are used.

// class Solution {
//     public List<List<Integer>> combinationSum3(int k, int n) {
//         List<List<Integer>> res = new ArrayList<>();
//         // the sum of all 9 nums, 1,2,3,..9 is 45
//         if (k < 1 || k > 9 || n < (1+k)*k/2 || n > 45) return res;
//         int[] nums = {1,2,3,4,5,6,7,8,9};
//         backtrack(nums, 0, k, n, res, new ArrayList<Integer>());
//         return res;
//     }

//     private void backtrack(int[] nums, int index, int k, int n, List<List<Integer>> res, List<Integer> tmp) {
//         if (tmp.size() == k && n == 0) {
//             res.add(new ArrayList<Integer>(tmp));
//             return;
//         }
//         if (n < 0 || index >= nums.length || tmp.size() > k) return;
//         tmp.add(nums[index]);
//         backtrack(nums, index + 1, k, n - nums[index], res, tmp);
//         tmp.remove(tmp.size() - 1);
//         backtrack(nums, index + 1, k, n, res, tmp);
//     }
// }


class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), k, 1, n); // using the num 1,2,.. to replace array and index
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> tmp, int k, int start, int n) {
        if (tmp.size() == k && n == 0) {
            res.add(new ArrayList<Integer>(tmp));
            return;
        }

        for (int i = start; i <=9; i++) {
            tmp.add(i);
            helper(res, tmp, k, i + 1, n - i);
            tmp.remove(tmp.size() - 1);
        }
    }
}