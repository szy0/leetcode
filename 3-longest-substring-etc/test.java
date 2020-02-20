import java.util.ArrayList;
import java.util.Arrays;

class test {
    static ArrayList<Integer> allSubStringLen = new ArrayList<Integer>();
    static int level=1;
    static String toShow = "";

    public static void recursionSplit(String s){
        ArrayList<String> newSub = new ArrayList<String>();

        if(s.length()==1){
            level+=1;
            allSubStringLen.add(level);
            return;
        }
        String headChar = s.split("")[0];
        String[] subString = s.split(headChar);
        
        for (int i=0; i<subString.length; i++){
            if (!subString[i].equals("")){ // I should not use == here. ==""  does not work.
                newSub.add(subString[i]);
            }
        }

        // for (String i : newSub){
        //     toShow += i;
        // }
        // System.out.println("to show is:"+ toShow);
        // System.out.println("newSub.size() is:"+ newSub.size());
        // System.exit(0);

        if (newSub.size() >=1){
            level +=1;
            for (String i : newSub){
                
                recursionSplit(i);
            }
        } else if (newSub.size() ==0){
            //level +=1;
            allSubStringLen.add(level);
            return;
        }


    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        } else if (s.length()==1){
            return 1;
        } else {
            recursionSplit(s);
        }

        int maxLevel = 0;
        for (int i : allSubStringLen){
            if(i>maxLevel){
                maxLevel = i;
            }
        }
        return maxLevel;
    }


    public static void main(String[] args) {
        String[] s0 ={"","a","ab","aaaaa",
                    "abcdeae",
                    "abcdeeabcdf","aabbcefgag"};
        
        // for (String i : s0){
        //     int maxL = lengthOfLongestSubstring(i);
        //     System.out.println("max Len of subString is "+maxL);
        // }
        int maxL = lengthOfLongestSubstring(s0[5]);
        System.out.println("max Len of subString is "+maxL);
        
    }
}