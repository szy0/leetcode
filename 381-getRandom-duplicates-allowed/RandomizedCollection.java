import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import java.util.Random;


// this question requires us to implement three methods, insert, remove and getRandom to
// make them all in O(1) time complexity.

// I feel this task is nearly impossible (at least for me). My solution can ensure that
// insert is O(1), getRandom() is O(1), but remove is O(n)


// this question (leetcode 381) is a harder version of leetcode 380
class RandomizedCollection {
    private Map<Integer, List<Integer>> map; // entry <val, a list of their indices in main list>
    private List<Integer> list; // main list to store the elements

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.map = new HashMap<Integer, List<Integer>>(); 
        this.list = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        if (map.containsKey(val)) {
            map.get(val).add(list.size() - 1);
            return false;
        } else {
            List<Integer> indices = new ArrayList<Integer>();
            indices.add(list.size() - 1);
            map.put(val, indices);
            return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        else {
            List<Integer> indices = map.get(val);
            int index = indices.get(indices.size() - 1); // the element to be removed, its index in the main list.
            indices.remove(indices.size() - 1);

            if (indices.isEmpty()) {
                map.remove(val);
            }

            if (index == list.size() - 1) {
                list.remove(list.size() - 1);
            } else {
                int last = list.get(list.size() - 1); // last element in the main list
                list.set(index, last); // overwrite this index with the last element
                list.remove(list.size() - 1);
                List<Integer> indicesForLast = map.get(last);
                indicesForLast.remove(indicesForLast.size() - 1);

                if (indicesForLast.size() == 0) indicesForLast.add(index);
                else {
                    // note: here is O(n) time complexity
                    int i = 0;
                    while (i <= indicesForLast.size() - 1 && index > indicesForLast.get(i)) {
                        i++;
                    }
                    indicesForLast.add(i, index);
                    // the indices list must be in sorted order
                }
                    
            }
             
            return true;
        }
           
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int e = new Random().nextInt(list.size());
        return list.get(e);
    }
}