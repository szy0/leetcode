class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        if (n == 0) return tasks.length;

        int[] chars = new int[26];
        for (char c : tasks) {
            chars[c - 'A']++;
        }
        Arrays.sort(chars);

        int i = 24;
        while (i >= 0 && chars[i] == chars[25]) i--;
        //  [AAAA BBBB CCCC DD E F]
        // finding the first task (let's say 'D') that has less amount than the most task (lets say 'A', then the amount of 'B' == 'A' and amount of 'C' == 'A')

        // the gap between 'A's + the amount of 'A' + (1'B' and 1 'c') after the last 'A'
        int leastGap = (chars[25] - 1) * n + chars[25] + (25 - i - 1); 

        return Math.max(tasks.length, leastGap);

        // we can think from the perspective of vacancy
        // the gap between 'A' is not necessary to be exactly n

        // if n = 3 and A---A---A---A can store all the tasks, this leads to leastGap
        // e.g. [ABCD ABCE ABFG AB] (leastGap == tasks.length)
        // e.g. [ABCD ABCE AB-- A] (leastGap > tasks.length)
        // e.g. [AB-- A--- A--- A] (leastGap > tasks.length)

        // but if there are more tasks than the least gap provided,
        // we have to elongate the gap between 'A'
        // e.g. if n = 1, [ABC ABC AD]   we can see that A-A-A cannot store the whole tasks,
        // so we let the gap = 2, which is larger than n = 1
        // also we can [ABCDEF ABC A] we can always use larger gaps to store as more tasks as possible
        // and in this case (tasks.length > leastGap)


        // in conclusion, if we use gap = n, and all tasks can be stored -> leastGap situation
        // if gap = n is not enough, we use larger gaps, and all tasks can be store -> tasks.length

        // and n = 3 [ABCDE ABC- A] will never happen
        // because we must ensure all gaps = n are used, before using larger gaps [ABCD ABCE A]
        // i.e. "GREEDY"
        // so that we can also keep all two same tasks with the "safe distance" of >n
    }
}