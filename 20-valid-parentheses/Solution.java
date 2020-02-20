import java.util.ArrayList;

class Solution {
    Solution(){}
    public boolean isValid(String s) { // "([])" is allowed, making it simpler 
                                    //since the priority of ()[]{} is not considered.
        ArrayList<String> myStack = new ArrayList<String>();
        int len = myStack.size();
        if (s.equals("")) return true;

        String[] allParenthese = s.split("");
        for (String i : allParenthese) {
            myStack.add(i);
            len = myStack.size();

            if (len == 1 && (i.equals(")") || i.equals("]") || i.equals("}")) ) {
                return false;
            }

            if (len >= 2) {
                boolean pair = isPair(myStack.get(len-2), myStack.get(len-1));
                if (pair) {
                    myStack.remove(len-1);
                    myStack.remove(len-2); // what happens after removing two elements?
                }    
            }
        }
        len = myStack.size();
        if (len > 0) {
            return false;
        }
        return true;
    }

    public boolean isPair(String a, String b) {
        if (a.equals("(") && b.equals(")")) return true;
        if (a.equals("[") && b.equals("]")) return true;
        if (a.equals("{") && b.equals("}")) return true;
        return false;
    }
}