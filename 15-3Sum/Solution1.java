// this is an ordinary, not tricky, O(n^2) solution. 
// I have not come up with some novel solutions, so I decided to firstly
// try this solution.

// This solution works. But exceeds time limit!

import java.util.Collections; // Collections contain ArrayList and List
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<Integer> negative = new ArrayList<Integer>();
        ArrayList<Integer> positive = new ArrayList<Integer>();
        ArrayList<Integer> zero = new ArrayList<Integer>();

        List<Integer> stageResult;
        List<List<Integer>> finalResult = new ArrayList<List<Integer>>();

        for (int i : nums){
            if (i < 0){
                negative.add(i);
            } else if (i > 0){
                positive.add(i);
            } else if (i == 0){
                zero.add(0);
            }
        }
        Collections.sort(negative);
        Collections.sort(positive);

        int nsize = negative.size();
        int psize = positive.size();
        int zsize = zero.size();

        // firstly, two negative + one positive
        // secondly, one negative + two positive
        // thirdly, one negative + 0 + one positive (only if existZero == true);
        // and one special case: [0,0,0]

        if (nsize>=2){
            for (int i=0; i<nsize-1; i++){
                int firstNegative = negative.get(i);
                for (int k=i+1; k<nsize; k++){
                    int secondNegative = negative.get(k);
                    int expectPositive = 0 - (firstNegative + secondNegative);
                    if (positive.contains(expectPositive)){
                        //int[] arr = {};
                        stageResult = Arrays.asList(firstNegative,secondNegative,expectPositive);
                        if (!finalResult.contains(stageResult)){
                            finalResult.add(stageResult);
                        }
                    }
                }
            }
        }

        if (psize>=2){
            for (int i=0; i<psize-1; i++){
                int firstPositvie = positive.get(i);
                for (int k=i+1; k<psize; k++){
                    int secondPositive = positive.get(k);
                    int expectNegative = 0 - (firstPositvie + secondPositive);
                    if (negative.contains(expectNegative)){
                        //int[] arr = {};
                        stageResult = Arrays.asList(expectNegative,firstPositvie,secondPositive);
                        if (!finalResult.contains(stageResult)){
                            finalResult.add(stageResult);
                        }                    
                    }
                }
            }

        }

        if (zsize>=1){
            if (nsize <= psize){
                for (int i=0; i<nsize; i++){
                    int oneNegative = negative.get(i);
                    int expectPositive = -oneNegative;
                    if (positive.contains(expectPositive)){
                        //int[] arr = {};
                        stageResult = Arrays.asList(oneNegative,0,expectPositive);
                        if (!finalResult.contains(stageResult)){
                            finalResult.add(stageResult);
                        }                    
                    }

                }

            } else {
                for (int i=0; i<psize; i++){
                    int onePositive = positive.get(i);
                    int expectNegative = -onePositive;
                    if (negative.contains(expectNegative)){
                        //int[] arr = {};
                        stageResult = Arrays.asList(expectNegative,0,onePositive);
                        if (!finalResult.contains(stageResult)){
                            finalResult.add(stageResult);
                        }                    
                    }

                }
            }


            if (zsize>=3){
                stageResult = Arrays.asList(0,0,0);
                finalResult.add(stageResult);
            }
        }

        return finalResult;
    }
}