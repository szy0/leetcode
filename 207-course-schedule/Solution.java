class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1]; // a <- b
            indegrees[a]++;
        }
        Queue<Integer> queue = new LinkedList<>(); // courses with 0 indegrees
        int count = 0; // num of courses with 0 degrees
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
                count++;
            }
        }
        while (!queue.isEmpty()) {
            int b = queue.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                // b is already finished, a depends on b
                if (prerequisites[i][1] == b) {
                    int a = prerequisites[i][0];
                    indegrees[a]--;
                    if (indegrees[a] == 0) {
                        queue.offer(a);
                        count++;
                    }
                }
            }
        }
        return count == numCourses;
    }
}