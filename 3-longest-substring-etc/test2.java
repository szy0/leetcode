import java.util.ArrayList;
import java.util.Arrays;
// I think I should use synchronized(line 10) and thread(line37)

class Solution extends Thread {
    private int level;
    //private String toShow = "";
    public Solution(int level){
        this.level = level;
    }
    public synchronized void recursionSplit(String s){
        ArrayList<String> newSub = new ArrayList<String>();

        if(s.length()==1){
            this.level+=1;
            test2.allSubStringLen.add(level);
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
            this.level +=1;
            for (String i : newSub){
                Solution newR = new Solution(this.level);
                Thread newT = new Thread(){
                    public void run(){
                        newR.recursionSplit(i);
                    }
                };
                newT.start();
            }
        } else if (newSub.size() ==0){
            //level +=1;
            test2.allSubStringLen.add(this.level);
            //System.out.println("x");
            return;
        }


    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        } else if (s.length()==1){
            return 1;
        } else {
            recursionSplit(s);
        }

        int maxLevel = 1;
        for (int i : test2.allSubStringLen){
            if(i>maxLevel){
                maxLevel = i;
            }
        }
        return maxLevel;
    }

}

public class test2{
    public static ArrayList<Integer> allSubStringLen = new ArrayList<Integer>();

    public static void main(String[] args) {
        String[] s0 ={"","a","ab","aaaaa",
                    "abcdeae",
                    "abcdeeabcdf","aabbcefgag"};
        
        // for (String i : s0){
        //     int maxL = lengthOfLongestSubstring(i);
        //     System.out.println("max Len of subString is "+maxL);
        // }
        Solution s = new Solution(0);
        int maxL = s.lengthOfLongestSubstring(s0[5]);
        System.out.println("max Len of subString is "+maxL);
        
    }
}