import java.util.*;

// credit to one my chinese fellow, his solution inspired me.
// This solution is almost the same with his, which uses a very quick, simple
// algorithm.

// we do not have to simulate calculating manually, the main idea is that for
// one digit of the product, we can assume that it accepts an integer [00 - 99],
// then dealing with carries later.

// one tricky thing is that for digit with larger index in product[],
// it represents smaller number.

class Solution {
    public String multiply(String num1, String num2) {
        String[] num1Arr = num1.split("");
        String[] num2Arr = num2.split("");
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 0 || len2 == 0) return "";
        if (num1.equals("0") || num2.equals("0")) return "0";  // avoiding dealing with "0000" result;
        int lenP = len1 + len2;
        int[] product = new int[lenP]; // either (i + j - 1) or (i + j) digits
        // [100 x 10] [999 x 99]

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                product[i + j + 1] += strToInt(num1Arr[i]) * strToInt(num2Arr[j]);
            }
        }

        // for (int k : product) {
        //     System.out.print(k + " ");
            
        // }
        // System.out.println();


        // dealing with carry
        int carry = 0;
        for (int k = lenP - 1; k >= 0; k--) {
            product[k] += carry;
            // the last digit of the current int in product, is the carry for the next int
            carry = product[k] / 10; 
            product[k] -= carry * 10; // real digit for this position
        }
        product[0] += carry;

        // avoiding possible leading zero
        String res = "";
        if (product[0] != 0) {
            for (int m : product) res += m;
        } else {
            for (int k = 1; k <= lenP-1; k++) {
                res += product[k];
            }
        }

        return res;

    }

    // this method does not work for BigInteger
    private int strToInt(String s) {
        return Integer.parseInt(s);
    }
}