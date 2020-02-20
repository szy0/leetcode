import java.util.ArrayList;

public class Solution {
    public String countAndSay(int n) {
        if (n <= 1) return "1"; // this is what the contributor wants
        if (n == 2) return "11";
        String s = countAndSay(n-1);
        //assert s.equals("21") : "Wrong!";
        String[] allNums = s.split("");
        int len = allNums.length;
        ArrayList<String> results = new ArrayList<String>();

        int i = 1;
        while (i < len) {
            int count = 1;
            while (i < len && allNums[i-1].equals(allNums[i]) ) {
                count++; 
                i++;
            }

            String r = count + allNums[i-1];
            results.add(r);
            i++;
        }

        if (!allNums[len-1].equals(allNums[len-2])) {
            String r = "1" + allNums[len-1];
            results.add(r);
        }


        String f = "";
        for (String k : results) {
            f += k;
        }
        return f;
    }

    public static void main(String[] args) {
        Solution n = new Solution();
        System.err.println(n.countAndSay(5));
    }
}