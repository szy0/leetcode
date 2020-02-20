import java.util.ArrayList;
// how to get the desired string? I need the index of the mid char and length.
class Solution {
    Solution(){}
    public String longestPalindrome(String s) { // neighbour and one gap
        int strLen = s.length();
        int maxSubStrLen = 0;
        String longestSubStr = "";

        String[] allChars = s.split("");
        System.out.println("string len is "+strLen);

        ArrayList<Integer> indexDouble = new ArrayList<Integer>(); 
        ArrayList<Integer> indexTriple = new ArrayList<Integer>(); 

        if (strLen == 0){
            return "";
        } else if (strLen == 1){
            return allChars[0];
        } else if (strLen == 2){
            if (allChars[0].equals(allChars[1])){
                return s;
            } else {
                return allChars[0];
            }
        } else {
            for (int i=0; i<strLen-1; i++){
                if (allChars[i].equals(allChars[i+1])){
                    indexDouble.add(i);
                }
            }
            for (int k=0; k<strLen-2; k++){
                if (allChars[k].equals(allChars[k+2])){
                    indexTriple.add(k);
                }
            }

            System.out.println("for double case, there are "+indexDouble.size());
            System.out.println("for triple case, there are "+indexTriple.size());
            System.out.printf("%d || %s\n",indexTriple.get(0),formStr(s, indexTriple.get(0),3));

            if (indexDouble.size()==0 && indexTriple.size()==0){
                return allChars[0];
            }

            if (indexDouble.size()!=0){
                maxSubStrLen = 2;
                longestSubStr = formStr(s, indexDouble.get(0), 2);

                for (int i : indexDouble){
                    int clen = 2;
                    int gap = 1;
                    while (i-gap>=0 && i+1+gap<= strLen-1 && 
                            allChars[i-gap].equals(allChars[i+1+gap])){
                        clen +=2;
                        gap+=1;
                    }
                    gap-=1;
                    if (maxSubStrLen<clen){
                        maxSubStrLen = clen;
                        longestSubStr = formStr(s, i-gap, clen);
                    }
                }
            }

            if (indexTriple.size()!=0){
                for (int i : indexTriple){
                    int clen = 3;
                    int gap = 1;
                    while (i-gap>=0 && i+2+gap<= strLen-1 && 
                            allChars[i-gap].equals(allChars[i+2+gap])){
                        clen +=2;
                        gap+=1;
                    }
                    gap-=1;
                    if (maxSubStrLen<clen){
                        maxSubStrLen = clen;
                        longestSubStr = formStr(s, i-gap, clen);
                    }
                }
                
            }
            System.out.println("The max len is "+maxSubStrLen);
            return longestSubStr;
        }
    }
    // public boolean isPalindrome(ArrayList<String> str){
    //     int len = str.size();
    //     for(int i=0; i<len/2; i++){
    //         String left = str.get(i);
    //         String right = str.get(len-1-i);
    //         if (!left.equals(right)){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    public String formStr(String s, int startIndex, int length){
        String[] allChars = s.split("");
        String resultStr = "";
        for (int k=startIndex; k<startIndex+length; k++){
            resultStr += allChars[k];
        }
        return resultStr;
    }
}