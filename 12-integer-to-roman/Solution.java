import java.util.ArrayList;

class Solution {
    Solution(){}
    public String intToRoman(int num) {
        ArrayList<Integer> splitNums = new ArrayList<Integer>();
        ArrayList<String> splitRomans = new ArrayList<String>();

        for (int i=0; i<=3; i++){
            int k = (int)Math.pow(10,i);
            if (i!=3){
                int splitNum = (num/k)%10;
                splitNums.add(splitNum);
            } else {
                int splitNum = num/k;
                splitNums.add(splitNum);
            }
        }

        // for (int i: splitNums){
        //     System.out.println(i);
        // }

        int one = splitNums.get(0);
        if (one >=1 && one <=3){
            String romanForOne = "";
            for (int k =1; k<=one; k++){
                romanForOne +="I";
            }
            splitRomans.add(romanForOne);

        } else if (one == 4){
            splitRomans.add("IV");

        } else if (one >= 5 && one <= 8){
            String romanForOne = "V";
            for (int k=0; k<one-5; k++){
                romanForOne += "I";
            }
            splitRomans.add(romanForOne);

        } else if (one == 9){
            splitRomans.add("IX");
        }

        
        int ten = splitNums.get(1); // should consider that ten does not exist
        if (ten >=1 && ten <=3){
            String romanForTen = "";
            for (int k=1; k<=ten; k++){
                romanForTen += "X";
            }
            splitRomans.add(romanForTen);

        } else if (ten == 4){
            splitRomans.add("XL");

        } else if (ten >=5 && ten <=8){
            String romanForTen = "L";
            for (int k=0; k<ten-5; k++){
                romanForTen += "X";
            }
            splitRomans.add(romanForTen);

        } else if (ten == 9){
            splitRomans.add("XC");
        }



        int hundred = splitNums.get(2);
        if (hundred>=1 && hundred <=3){
            String romanForHundred = "";
            for (int k=1; k<=hundred; k++){
                romanForHundred += "C";
            }
            splitRomans.add(romanForHundred);

        } else if (hundred == 4){
            splitRomans.add("CD");

        } else if (hundred >=5 && hundred <=8){
            String romanForHundred = "D";
            for (int k=0; k<hundred-5; k++){
                romanForHundred += "C";
            }
            splitRomans.add(romanForHundred);

        } else if (hundred == 9){
            splitRomans.add("CM");
        }

        int thousand = splitNums.get(3);
        String romanForThousand = "";
        for (int k =1; k<=thousand; k++){
            romanForThousand += "M";
        }
        splitRomans.add(romanForThousand);
       

        String result = "";
        int amount = splitRomans.size();
        for (int k = amount-1; k>=0; k--){
            result += splitRomans.get(k);
        }

        return result;
    

    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] testNums = {1,2,3,4,5,8,9,10,14,15,16,18,19,20,30,
                            34,35,40,50,80,90,99,100,
                            200,400,499,500,800,999,1000,1994,2000,4000,
                            9000,10321,15234};
        for (int num : testNums){
            String result = s.intToRoman(num);
            System.out.printf("Num:%d  Roman:%s\n",num,result);
        }
        
    }
}