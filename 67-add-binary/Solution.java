// inspired by others
// I havent completed

class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;

        String res = "";
        int carry = 0;
        int sum = 0;

        while (i >= 0 || j >= 0) {
            sum += carry;
            if (i >= 0) sum += a.charAt(i--) - '0'; // very interesting trick
            if (j >= 0) sum += b.charAt(j--) - '0';
    
            res = sum % 2 + res;
            carry = sum / 2;
        }

        if (carry > 0) res = "1" + res;
        return res;

    }
}