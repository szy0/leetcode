// even I cannot fully understand my solution
// I think it works this way: the disappearance of some values is led by duplicates
// of some other values, once we find a duplicate of one value, we note it as -1
// -1 means a vacancy, then we move this vacancy through the iteration

// At last, where the vacancy(s) stays is the lack of corresponding value(s)

// one obvious drawback is that this solution changes the input array
class Solution {
    // the size of arr could be zero
    // for arr = [1], we cannot find a situation where it is not completed
    // for arr.length = 2, only has two situations, arr = [1,1] or arr = [2,2]

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                if (nums[i] != -1) {
                    int val = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    if (nums[i] != val) {
                        nums[i] = val;
                        i--;
                    } else {
                        nums[i] = -1; // -1 is denoted by me, meaning that the value (i + 1) is disappeared
                    }
                  
                }
                
            }
            i++;
        } 
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == -1) {
                res.add(k + 1);
            }
        }
        return res;
    }
}