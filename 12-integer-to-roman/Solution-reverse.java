import java.util.ArrayList;
import java.util.Arrays;

class Solution { // fan xiang
    public static void main(String[] args) {
        String[] testromans = {"III","IV","VI","VIII","IX","XIV","XVIII","XIX",
                            "XXXVII","XXXIX","XL","XLII","XLIV","XLVIII","XLIX","L",
                            "LIV","LIX","LXXIX",
                            "XC","XCIV","XCVI","XCIX","C",
                            "MCMXCIV"};
        // ArrayList<Integer> nums = new ArrayList<Integer>();
        for (String i : testromans){
            System.out.print(i+" ");
            System.out.print(romanToInt(i)+"\n");
        }
    }
    public static int romanToInt(String s) {
        String[] raw = s.split("");
        ArrayList<String> romans = new ArrayList<String>();
        ArrayList<Integer> values = new ArrayList<Integer>();

        int value;
        for (String i : raw){
            romans.add(i);
            switch (i) {
                case "I":
                    value = 1;
                    values.add(value);
                    break;
                case "V":
                    value = 5;
                    values.add(value);
                    break;
                case "X":
                    value = 10;
                    values.add(value);
                    break;
                case "L":
                    value = 50;
                    values.add(value);
                    break;
                case "C":
                    value = 100;
                    values.add(value);
                    break;
                case "D":
                    value = 500;
                    values.add(value);
                    break;
                case "M":
                    value = 1000;
                    values.add(value);
                    break;
                default:
                    break;
            }
        }

        int length = romans.size();
        for (int k=0; k<length-1; k++){
            String left = romans.get(k);
            String right = romans.get(k+1);

            if (left.equals("I") && (right.equals("V") ||right.equals("X"))){
                values.set(k, values.get(k)*(-1));
            }
            if (left.equals("X") && (right.equals("L") || right.equals("C"))){
                values.set(k, values.get(k)*(-1));
            }
            if (left.equals("C") && (right.equals("D") || right.equals("M"))){
                values.set(k, values.get(k)*(-1));
            }
        }




        int sum = 0;
        for (int n : values){
            sum += n;
        }
        return sum;

    }
}