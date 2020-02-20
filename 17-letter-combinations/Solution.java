import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();

        List<List<String>> allStrings = new ArrayList<List<String>>();
        String[] allDigits = digits.split("");
        for (String i : allDigits) {
            List<String> a = intToLetters(i);
            allStrings.add(a);
        }

        List<String> currentResult = allStrings.get(0);
        if (allStrings.size()==0) return combinations;
        if (allStrings.size()==1) return currentResult;
        for (int k=0; k<allStrings.size()-1; k++) {
            currentResult = crossMultiply(currentResult, allStrings.get(k+1));
        }
        return currentResult;

    }


    public List<String> intToLetters(String digit) {
        List<String> letters = new ArrayList<String>();
        switch (digit) {
            case "2":
                letters = Arrays.asList("a","b","c");
                break;               
            case "3":
                letters = Arrays.asList("d","e","f");
                break;                
            case "4":
                letters = Arrays.asList("g","h","i");
                break;                
            case "5":
                letters = Arrays.asList("j","k","l");
                break;
            case "6":
                letters = Arrays.asList("m","n","o");
                break;
            case "7":
                letters = Arrays.asList("p","q","r","s");
                break;  
            case "8":
                letters = Arrays.asList("t","u","v");
                break;
            case "9":
                letters = Arrays.asList("w","x","y","z");
                break;
            default:
                break;
        }
        return letters;
    }


    public List<String> crossMultiply(List<String> str1, List<String> str2) {
        List<String> result = new ArrayList<String>();

        int len1 = str1.size();
        int len2 = str2.size();
        for (int i=0; i<len1; i++) {
            for (int k=0; k<len2; k++) {
                String a = str1.get(i);
                String b = str2.get(k);
                result.add(a+b);
            }
        }
        return result;
    }
}