import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> one = new ArrayList<Integer>();
        List<List<Integer>> all = new ArrayList<List<Integer>>();

        Arrays.sort(nums);
        int len = nums.length;

        if (len == 0) {
            all.add(one);
            return all;
        }
        if (len == 1) {
            one.add(nums[0]);
            all.add(one);
            return all;
        }

        int[] prev = removeLast(nums);
        int last = nums[len - 1];


       
        //ArrayList<Integer> prevResult = arrToArrList(prev);
        List<List<Integer>> prevAll = permuteUnique(prev);
        for (List<Integer> m : prevAll) {
            List<List<Integer>> part = insertToPermute(m, last);
            for (List<Integer> n : part) {
                if (!all.contains(n))
                all.add(n);  
            }
            
        } 

        
        //System.out.println(all.size());
        return all;
    }

    public int[] removeLast(int[] nums) {
        int len = nums.length;
        if (len <= 1) return new int[0];
        int[] result = new int[len-1];
        for (int k=0; k<len-1; k++){
            result[k] = nums[k];
        }
        return result;
    }

    public ArrayList<Integer> arrToArrList(int[] arr) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int k : arr) {
            result.add(k);
        }
        return result;
    }

    public List<List<Integer>> insertToPermute(List<Integer> m, int a) { // wrong here!
        int len = m.size();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        //System.out.println(len);
        for (int k=0; k<= len; k++) { // i cannot let temp = m, this would be passed by reference
            List<Integer> temp = new ArrayList<Integer>();
            for (int i : m) {
                temp.add(i);
            }
            temp.add(k,a);
            //printList(temp);
            result.add(temp);
        }
        //System.out.println("haha " + result.get(0).size());
        return result;
    } 

    public List<List<Integer>> backInsertToPermute(List<Integer> m, int[] arr) {
        int len = arr.length;
        int val = arr[0]; // all values in the arr are the same
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int k=0; k<= len; k++) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int i : m) {
                temp.add(i);
            }
            int left = 0;
            int right = 0;
            while (left < k) {
                temp.add(0, val);
                left ++;
            }
            while (right < len-k) {
                temp.add(val);
                right ++;
            }
            //printList(temp);
            result.add(temp);
            
        }
        return result;

    }

    public void printList(List<Integer> m) {
        for (int k : m) {
            System.out.print(k + " ");
        }
        System.out.print("\n");
    }

}