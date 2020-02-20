import java.util.ArrayList;

class Solution {
    Solution(){}
    public static ArrayList<Integer> allSubStringLen = new ArrayList<Integer>();

    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        } else if (s.length()==1){
            return 1;
        } else {
            Runnable r = new splitString(s, 1);
            Thread t = new Thread(r);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e){
                System.out.print("thread error");
            }

            int maxLevel = 0;
            for (int i : allSubStringLen){
                if(i>maxLevel){
                    maxLevel = i;
                }
            }
            return maxLevel;
        }
        
    }

    // public static void main(String[] args) {
    //     String[] s0 ={"","a","ab","aaaaa",
    //                 "abcdeae",
    //                 "abcdddaccefghabc","aabbcceabdfecc"};
        
    //     // for (String i : s0){
    //     //     int maxL = lengthOfLongestSubstring(i);
    //     //     System.out.println("max Len of subString is "+maxL);
    //     // }
    //     int maxL = lengthOfLongestSubstring(s0[5]);
    //     System.out.println("max Len of subString is "+maxL);
        
    // }
}


class splitString implements Runnable{
    private int cLevel; //current level
    private String cStr; // current string
    public splitString(String str, int level){
        this.cLevel = level;
        this.cStr = str;
    }
    @Override
    public synchronized void run(){
        ArrayList<String> newSub = new ArrayList<String>();

        // if(cStr.length()==1){
        //     this.cLevel+=1;
        //     Solution.allSubStringLen.add(cLevel);
        //     return;
        // }
        String headChar = cStr.split("")[0];
        String[] subString = cStr.split(headChar);
        
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
        ArrayList<Thread> allThreads = new ArrayList<Thread>();
        if (newSub.size() >=1){
            this.cLevel +=1;
            for (int k=0; k<newSub.size(); k++){
                Runnable newR = new splitString(newSub.get(k), this.cLevel);
                System.out.printf("string is %s and level is %d",newSub.get(k),this.cLevel);
                Thread newT = new Thread(newR);
                allThreads.add(newT);
            }
            for (Thread m : allThreads){
                m.start();
                try{
                    m.join();
                } catch (InterruptedException e){
                    System.out.println("thread interrupted!");
                }
               
            }
        } else if (newSub.size() ==0){
            //cLevel +=1;
            Solution.allSubStringLen.add(this.cLevel);
            //System.out.println("x");
            return;
        }
    }
}   