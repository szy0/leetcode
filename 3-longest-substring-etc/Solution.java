class Solution {
    Solution(){}
    public int lengthOfLongestSubstring(String s) {
        int stringLen = s.length();
        int maxLen = 1;
        ArrayList<Integer> allStrLen = new ArrayList<Integer>();

        if (stringLen == 0){
            return 0;
        } else if (stringLen == 1){
            return 1;
        } else {
            String currentStr = String.valueOf(s.charAt(0));
            for (int i=1; i<stringLen; i++){
                char j = s.charAt(i);
                String k = String.valueOf(j);
                int index = isRepetitive(currentStr,k);
                if (index == -1){ // means no repeat
                    currentStr += k;
                } else {
                    allStrLen.add(currentStr.length());
                    currentStr = moveStr(currentStr, index);
                }
            }
            allStrLen.add(currentStr.length());

            for (int i : allStrLen){
                if(i>maxLen){
                    maxLen = i;
                }
            }
            return maxLen;
        }

            
    }
    

    public int isRepetitive(String currentStr, String k) {
        String[] allChars = currentStr.split("");
        int amount = allChars.length;
        for (int i=0; i<amount; i++){
            if (k.equals(allChars[i])){
                return i; // return index
            }
        }
        return -1; // means no repeat
    }

    public String moveStr(String currentStr, int index) {
        String[] allChars = currentStr.split("");
        int amount = allChars.length;
        String[] newChars = new String[amount-index];
        for (int k = index+1; k<amount; k++){
            newChars[k-index-1] = allChars[k];
        }
        newChars[amount-index-1] = allChars[index];

        String str = "";
        for(String i : newChars){
            str += i;
        }
        return str;
    }
}