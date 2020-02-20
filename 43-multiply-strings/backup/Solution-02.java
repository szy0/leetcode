import java.util.ArrayList;

// This solution is far too complex. This is so far the longest
// code Ive ever written for leetcode problems.

// It works. Tests passed.
// But I really need to learn from other users.



class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("") || num2.equals("")) return "";
        if (num1.equals("0") || num2.equals("0")) return "0";



        ArrayList<String[]> allStr = new ArrayList<String[]>();
        ArrayList<ArrayList<String>> allStr2 = new ArrayList<ArrayList<String>>();
        ArrayList<String> resultStr = new ArrayList<String>();
        String finalStr = "";

        int len1 = num1.length();
        int len2 = num2.length();
        
        if (len1 < len2) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
            len1 = num1.length();
            len2 = num2.length();
        }
        //System.out.println("num2 is: " + num2);

        String[] nums2 = num2.split("");
        for (String t : nums2) {
            allStr.add(multiplyWithOneDigit(num1, t));
        }
        // for (String[] h : allStr) {
        //     for(String k: h) System.out.print(k);
        //     System.out.println();
        // }

        allStr2 = fillZero(allStr);

        for (ArrayList<String> h : allStr2) {
            for(String k: h) System.out.print(k);
            System.out.println();
        }

        for (ArrayList<String> a : allStr2) {
            resultStr = helper.addTwoStr(resultStr, a);
        }
        for (String k : resultStr) {
            finalStr += k;
        }

        return finalStr;


    }


    public String[] multiplyWithOneDigit(String a, String b) { // b is a one-digit string
       String[] s1 = a.split("");
       int len1 = s1.length;
       int[] arr1 = new int[len1];
       for (int i=0; i<len1; i++) {
           arr1[i] = Integer.parseInt(s1[i]);
       }
       int num2 = Integer.parseInt(b);

       ArrayList<Integer> result = new ArrayList<Integer>();
       int prevCarry = 0;
       int currentCarry = 0;

       for (int k=0; k<len1; k++) {
           prevCarry = currentCarry;
           int num1 = arr1[len1-1-k];
           int digit = (num1 * num2 + prevCarry)%10;
           currentCarry = (num1 * num2 + prevCarry)/10;
           result.add(0, digit);
       }

       if (currentCarry > 0) result.add(0, currentCarry);
       String s = arrListToStr(result);
       return s.split("");

    }

    public <E> String arrListToStr(ArrayList<E> m) {
        String s = "";
        for (E k : m) {
            s += k;
        }
        return s;
    }

    public ArrayList<ArrayList<String>> fillZero(ArrayList<String[]> allStr) { // in order to add up (multipy with one digit)
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        int len = allStr.size();
        for (int k=0; k<len-1; k++) {// the last one does not need to fill zero
            String[] c = allStr.get(k);
            ArrayList<String> cc = strArrToList(c);
            //for (int i=0; i<k; i++) cc.add(0,"0");
            for (int t=0; t<len-k-1; t++) cc.add("0"); 
            result.add(cc);
        }
        result.add(strArrToList(allStr.get(len-1)));
        return result;
    }

    public ArrayList<String> strArrToList(String[] arr) {
        ArrayList<String> result = new ArrayList<String>();
        for (String k : arr) {
            result.add(k);
        }
        return result;
    }
}



class helper {
    public static ArrayList<String> addTwoStr(ArrayList<String> s1, ArrayList<String> s2) {
        ArrayList<Integer> val1 = new ArrayList<Integer>();
        ArrayList<Integer> val2 = new ArrayList<Integer>();
        ArrayList<String> finalSum = new ArrayList<String>();

        int len1 = s1.size();
        int len2 = s2.size();

        for (int k=0; k<len1; k++) {
            val1.add(Integer.parseInt(s1.get(k)));
        }

        for (int j=0; j<len2; j++) {
            val2.add(Integer.parseInt(s2.get(j)));
        }

        if (len1 < len2) { // make sure that val1 is the longer one, this will be more convenient
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp = val1;
            val1 = val2;
            val2 = temp;
            len1 = val1.size(); // do not forget to change lens
        }

        extendShortList(len1, val2); //add zero to head of short list i.e.val2
        len2 = len1;


        //finalSum.set(0, 0); // I think this may not be necessary, cause default is 0
        int prevCarry = 0;
        int currentCarry = 0;
        while (len1 > 0) {
            prevCarry = currentCarry;

            int a = val1.get(len1-1);
            int b = val2.get(len2-1);
            int[] sum = sumOneDigit(a, b);
            currentCarry = sum[0];

            finalSum.add(0, Integer.toString((sum[1] + prevCarry)%10));
            if (sum[1] + prevCarry == 10) currentCarry++;

            len1--; // actually len 1 == len 2 now
            len2--; // i am not gonna pop the last element in val1 and val2, len1&2 will not change with that
        }

        if (currentCarry == 1) finalSum.add(0, "1");
    
        return finalSum;

    }

    public static int[] sumOneDigit(int a, int b) {
        int[] result = new int[2]; // carry and one value
        // by default carry = 0
        result[1] = (a + b) % 10;
        if (a+b >= 10) result[0] = 1;
        return result;
    }

    public static void extendShortList(int len1, ArrayList<Integer> val2) { // in-place extend, directly change original val2.
        int len2 = val2.size();
        int gap = len1 - len2;
        for (int k=0; k<gap; k++) {
            val2.add(0, 0);
        }
    }
}


  