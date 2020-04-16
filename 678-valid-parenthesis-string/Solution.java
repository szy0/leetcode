import java.util.*;
// the solution from the problem author is also awesome!


// another very interesting solution from other coders
public boolean checkValidString(String s) {
    int bal = 0;
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(' || s.charAt(i) == '*') bal++;
        else if (bal-- == 0) return false;
    }
    if (bal == 0) return true;
    bal = 0;
    for (int i = s.length()-1; i >= 0; i--) {
        if (s.charAt(i) == ')' || s.charAt(i) == '*') bal++;
        else if (bal-- == 0) return false;
    }
    return true;
}




// from other coders
class Solution {
    public boolean checkValidString(String s) {
        return check(s, 0, 0);
    }
    
    private boolean check(String s, int start, int count) {
        if (count < 0) return false;
        
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            }
            else if (c == ')') {
                if (count <= 0) return false;
                count--;
            }
            else if (c == '*') {
                return check(s, i + 1, count + 1) || check(s, i + 1, count - 1) || check(s, i + 1, count);
            }
        }
        
        return count == 0;
    }
}






class Solution {
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) return true;
        return backtrack(s.toCharArray(), 0, new ArrayList<Character>());
    }

    // a simplified version
    // not working correctly!!
    private boolean backtrack(char[] arr, int index, List<Character> stack) {
        if (stack.size() > 0 && stack.get(stack.size() - 1) == ')') return false;
        if (index == arr.length) {
            if (stack.size() == 0) return true;
            else return false;
        }

        if (arr[index] == '(') {
            stack.add(arr[index]);
            return backtrack(arr, index + 1, stack);

        } else if (arr[index] == ')') {
            if (stack.size() == 0) return false;
            else {
                stack.remove(stack.size() - 1);
                return backtrack(arr, index + 1, stack);
            }

        } else {
            List<Character> t1 = new ArrayList<>(stack);
            t1.add('(');
            return backtrack(arr, index + 1, t1) || backtrack(arr, index + 1, stack); 
        }
    }

    // this one works, but very slow
    // private boolean backtrack(char[] arr, int index, List<Character> stack) {
    //     if (index == arr.length) {
    //         if (stack.size() == 0) return true;
    //         else return false;
    //     }

    //     if (stack.size() == 0) {
    //         if (arr[index] != '*') {
    //             stack.add(arr[index]);
    //             return backtrack(arr, index + 1, stack);
    //         } else {
    //             List<Character> t1 = new ArrayList<>(stack);
    //             t1.add('(');
    //             return backtrack(arr, index + 1, t1) || backtrack(arr, index + 1, stack); 
    //         }
            

    //     } else {
    //         if (stack.get(stack.size() - 1) == ')') return false;
    //         else if (arr[index] == ')') {
    //             stack.remove(stack.size() - 1);
    //             return backtrack(arr, index + 1, stack);
    //         } else if (arr[index] == '(') {
    //             stack.add(arr[index]);
    //             return backtrack(arr, index + 1, stack);
    //         } else {
    //             List<Character> t1 = new ArrayList<>(stack);
    //             List<Character> t2 = new ArrayList<>(stack);
    //             t1.add('(');
    //             t2.remove(stack.size() - 1);
    //             return backtrack(arr, index + 1, t1) || backtrack(arr, index + 1, t2) || backtrack(arr, index + 1, stack); 
    //         }
    //     }
          
    // }
}