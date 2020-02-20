class Solution {
        public String longestCommonPrefix(String[] strs) {
            int amount = strs.length; // how many elements in this array
    
            if (amount == 0){
                return "";
            } else if (amount == 1){
                return strs[0];
            } else {
                int len0 = strs[0].length();
                int len1 = strs[1].length();
                String strA = (len0>len1)?strs[0]:strs[1]; // A longer than B
                String strB = (len0>len1)?strs[1]:strs[0];

                while (!strA.startsWith(strB)){
                    strB = strB.substring(0,strB.length()-1);  // contains chars from [0,lastone) i.e remove the last char
                }

                if (amount == 2){
                    return strB;
                } else {
                    for (int i=2; i<amount; i++){
                        if (strs[i].length() >= strB.length()){
                            strA = strs[i];
                            while (!strA.startsWith(strB)){
                                strB = strB.substring(0,strB.length()-1);  // contains chars from [0,lastone) i.e remove the last char
                            }
                        } else {
                            strA = strB;
                            strB = strs[i];
                            while (!strA.startsWith(strB)){
                                strB = strB.substring(0,strB.length()-1);  // contains chars from [0,lastone) i.e remove the last char
                            }
                        }
                        
                    }
                    return strB;
                }
    

            }
        }
    }