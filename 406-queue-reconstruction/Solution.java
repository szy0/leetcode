import java.util.Arrays;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (n1, n2) -> (n2[0] == n1[0])?  n1[1] - n2[1] : n2[0] - n1[0]);
        List<int[]> res = new LinkedList<>();
        for(int[] p : people)  res.add(p[1], p);
        return res.toArray(new int[people.length][2]);
    }
}


// class Solution {
//     public int[][] reconstructQueue(int[][] people) {

//         Arrays.sort(people, (int[] a, int[] b) -> {
//             if (a[0] > b[0]) return 1;
//             if (a[0] < b[0]) return -1;
//             else {
//                 return a[0] < b[0] ? -1 : 1; // there will not exist two persons with the same [a,b]
//             } 
//         });
//         printPeople(people);


//         int[][] res = new int[people.length][2];

//         for (int i = 0; i < people.length; i++) {
//             //int offset = people.length -1 - i;
//             if (res[i][0] != 0) {
//                 for (int j = i; j < people.length; j++) {
//                     if (res[j][0] == 0) res[j] = people[i];
//                 }
//             }
//             else {
//                 res[people[i][1]] = people[i];
//             }
           
//         }

        
//         return res;
//     }

//     // public int[][] reconstructQueue(int[][] people) {
        
//     // }




//     private void printPeople(int[][] people) {
//         for (int[] p : people) {
//             System.out.println(p[0] + " " + p[1]);
//         }
//         System.out.println();
//     }
// }