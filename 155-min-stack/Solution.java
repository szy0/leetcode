import java.util.*;
class MinStack {
    List<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<>();
    }
    
    public void push(int x) {
        stack.add(x); // support autoboxing, int -> Integer
    }
    
    public void pop() {
        if (stack.size() >= 1) {
            stack.remove(stack.size() - 1); // removing index
        } else {
            return;
        }
        
    }
    
    public int top() {
        if (stack.size() >= 1) {
            int res = stack.get(stack.size() - 1);
            pop();
            return res;
        } else {
           return null;
        }
    }
    
    public int getMin() {
        if (stack.size() >= 1) {
            int res = stack.get(0);
            for (int k : stack) {
                if (k < res) res = k;
            }
            return res;
        } else {
            return null;
        }
      
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */