// class Solution {
//     // rowIndex starts from 0
//     public List<Integer> getRow(int rowIndex) {
//         List<Integer> res = new ArrayList<>();
//         res.add(1);
//         if (rowIndex == 0) return res;
   
//         List<Integer> prev = getRow(rowIndex-1);

//         for (int i = 1; i < rowIndex; i++) {
//             res.add(prev.get(i-1) + prev.get(i));
//         }
//         res.add(1);
//         return res;
//     }
// }

class Solution {
    // rowIndex starts from 0
    public List<Integer> getRow(int rowIndex) {
        Integer[] res = new Integer[rowIndex + 1];
        Arrays.fill(res, 0);
        res[0] = 1;
        
        for (int i = 1; i < rowIndex + 1; i++) {
            for (int j = i; j >=1; j--) {
                res[j] += res[j-1];
            }
        }
        return Arrays.asList(res);
    }
}
