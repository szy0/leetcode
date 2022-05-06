class Solution {
    public String addStrings(String num1, String num2) {      
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 < len2) {
            String tmp;
            tmp = num1;
            num1 = num2;
            num2 = tmp;
            
            len1 = num1.length();
            len2 = num2.length();
        }
        // System.out.println(num1 + "|" + len1);
        // System.out.println(num2 + "|" + len2);

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int digit = 0;
        int i, j;
        for (i = 0; i < len2; i++) {
            int a = num1.charAt(len1 - 1 - i) - '0';
            int b = num2.charAt(len2 - 1 - i) - '0';
            if (a + b + carry >= 10) {
                digit = a + b + carry - 10;
                carry = 1;
            } else {
                digit = a + b + carry;
                carry = 0;
            }
            // System.out.println("digit: " + digit);
            sb.append(digit);
        }
        for (j = len1 - len2 - 1; j >= 0; j--) {
            int a = num1.charAt(j) - '0';
            if (a + carry >= 10) {
                digit = a + carry - 10;
                carry = 1;
            } else {
                digit = a + carry;
                carry = 0;
            }
            // System.out.println("digit: " + digit);
            sb.append(digit);
        }
        if (carry == 1) {
            sb.append('1');
        }
            
        return sb.reverse().toString();
    }
}