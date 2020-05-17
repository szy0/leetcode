// import java.util.*;
// // a straightforward but slow approach
// class Solution {
//     public boolean backspaceCompare(String S, String T) {
//         int len1 = S.length();
//         int len2 = T.length();
        
//         List<String> stack1 = new ArrayList<>();
//         List<String> stack2 = new ArrayList<>();

//         for (int i = 0; i < len1; i++) {
//             String temp = S.charAt(i) + "";
//             if (stack1.size() == 0) {
//                 if (!temp.equals("#")) stack1.add(temp);
//             } else {
//                 if (temp.equals("#")) stack1.remove(stack1.size() - 1);
//                 else stack1.add(temp);
//             } 
//         }

//         for (int j = 0; j < len2; j++) {
//             String temp = T.charAt(j) + "";
//             if (stack2.size() == 0) {
//                 if (!temp.equals("#")) stack2.add(temp);
//             } else {
//                 if (temp.equals("#")) stack2.remove(stack2.size() - 1);
//                 else stack2.add(temp);
//             } 
//         }

//         if (stack1.size() != stack2.size()) 
//             return false;
//         else {
//             for (int m = 0; m < stack1.size(); m++) {
//                 if (!stack1.get(m).equals(stack2.get(m))) return false;
//             }
//         }

//         return true;

//     }
// }


// the concept of "two pointers"
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int ps1 = 0, ps2 = 0;
        int pt1 = 0, pt2 = 0;

        while (ps1 < S.length()) {
            if (String.valueOf(S.charAt(ps1)).equals("#")
        }
    }
}