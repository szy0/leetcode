import java.util.ArrayList;
/**
 * it works. but it is not a fast solution.
 * Time limit exceeded.
 */
class Solution1 {
    public int maxArea(int[] height) {
        ArrayList<Integer> height2 = new ArrayList<Integer>();
        ArrayList<Integer> allArea = new ArrayList<Integer>();

        for (int i : height){
            height2.add(i);
        }

        int length = height2.size();
        int leftHeight = 0;
        int rightHeight = 0;
        int gap = 0;

        for(int k=0; k<length-1; k++){
            leftHeight = height2.get(k);

            for (int m=length-1; m>k; m--){   
                rightHeight = height2.get(m);

                if(rightHeight<leftHeight){
                    gap = m-k;
                    int area = gap*rightHeight;
                    allArea.add(area);
                } else {
                    if (m-k>gap){
                        gap = m-k;
                    }
                }
            }
            int area = gap*leftHeight;
            allArea.add(area);
        }

        int maxArea = 0;
        for(int i : allArea){
            if (i>maxArea){
                maxArea = i;
            }
        }
        return maxArea;

    }
}