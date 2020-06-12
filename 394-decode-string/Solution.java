class Solution {
    public String decodeString(String s) {
        int p1 = 0, p2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                p1 = i;
            }
            if (s.charAt(i) == ']') {
                p2 = i;
                break;
            }
        }
        if (p2 == 0) return s; // locate the first []

        //System.out.println(p1 + "," + p2);

        int times = 0;
        int p3 = 0;
        // find the whole num e.g. 10000[abcde] -> find 10000
        for (int k = p1-1; k >= 0; k--) {
            String n = String.valueOf(s.charAt(k));
            if (!n.matches("[0-9]")) {
                times = Integer.valueOf(s.substring(k + 1, p1));
                p3 = k;
                //System.out.println("times: " + times);
                break;
            }
            if (k == 0){
                times = Integer.valueOf(s.substring(0, p1));
                p3 = -1;
                //System.out.println("times: " + times);
                break;
            }
        }
      

        String str = s.substring(p1 + 1, p2);
        String strRepeated = "";
        for (int j = 0; j < times; j++) {
            strRepeated += str;
        }
        s = s.substring(0, p3 + 1) + strRepeated + s.substring(p2 + 1, s.length());
        //System.out.println(s);
        return decodeString(s); // only remove one pair of "[]" for each recursion 
    }
}