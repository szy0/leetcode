import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n==0) {
            result.add("");
            return result;
        }
        if (n==1) {
            result.add("()");
            return result;
        }
        
        for (int left = 1; left<=n/2; left++) { // allocating amount of left pairs and right pairs
            int right = n-left;
            List<String> leftPart = generateParenthesis(left);
            List<String> rightPart = generateParenthesis(right); 
            for (String k : leftPart) {
                for (String m : rightPart) {
                    String s1 = k + m;
                    String s2 = m + k;
                    if (!result.contains(s1)) {
                        result.add(s1);
                    }
                    if (!result.contains(s2)) {
                        result.add(s2);
                    }   
                }
            }
        }


        List<String> lastResult = generateParenthesis(n-1);
        for (String i : lastResult) {
            String s3 = "(" + i + ")";
            if (!result.contains(s3))
                result.add(s3);
        }
        return result;
        
    }
}

// (()) (())  n = 4