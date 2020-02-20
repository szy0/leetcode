import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> temp = new ArrayList<List<Integer>>(); // used to store result from threeSum method
        List<Integer> one = new ArrayList<Integer>(); // one result
        List<List<Integer>> allResults = new ArrayList<List<Integer>>();// final results

        if (len<=3) return allResults;

        for (int i=0; i<=len-4; i++) { // pay attention to some special cases, like [2,2,2,2,2,2,2] and target = 4
            while (i>=1 && i<=len-4 && nums[i] == nums[i-1]) {
                i++;
            }
            if (i>len-4) return allResults;
            temp = threeSum(nums, i, target);
            for (List<Integer> k : temp) {
                int a = k.get(0);
                int b = k.get(1);
                int c = k.get(2);
                one = Arrays.asList(nums[i],a,b,c);
                allResults.add(one);
            }
        }
        return allResults;

        
    }

    // this method is copied from the solution of problem "3Sum".
    // I modified it a little that I introduced a new variable "target"
    // and use a new array nums2
    public List<List<Integer>> threeSum(int[] nums, int firstIndex, int globalTarget) { // nums is already sorted
        List<List<Integer>> finalResult = new ArrayList<>();
        
        int len = nums.length-firstIndex-1; // special cases are not included here
        int[] nums2 = new int[len];
        int target = globalTarget-nums[firstIndex];

        for (int k=0; k<len; k++) {
            nums2[k] = nums[k + firstIndex + 1];
        }

        for (int i=0; i<len-1; i++) {
            int left = i+1;
            int right = len-1;
            while (left < right) {
                int sum = nums2[i] + nums2[left] + nums2[right];
                if (sum < target) left++;
                if (sum > target) right--;
                if (sum == target) { // original code is "0", here are all "target"
                    finalResult.add(Arrays.asList(nums2[i], nums2[left], nums2[right]));
                    left++;
                    right--;
                    while (left<right && nums2[left]==nums2[left-1]) left++;
                    while (left<right && nums2[right]==nums2[right+1]) right--;
                }
            }

            while (i<len-1 && nums2[i]==nums2[i+1]){
                i++;
            }
        }
        return finalResult;
    }
}