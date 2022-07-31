import java.util.LinkedList;

class Solution1 {
    LinkedList<Integer> list = new LinkedList<>();
    public int lastRemaining(int n) {
        if (n == 1) return 1;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0)
                list.add(i); // do not add 1,3,5... in the very beginning
        }

        System.out.println(list);
        // because we did not add odd nums, so we do R2L first, then L2R
        while (list.size() > 1) {
            eliminateR2L();
            if (list.size() == 1) break;
            eliminateL2R();
        }
        return list.peek();
    }
    private void eliminateL2R() {
        LinkedList<Integer> tmp = new LinkedList<>();
        int i = 0;
        while (list.size() != 0) {
            int a = list.removeFirst();
            if (i % 2 == 1) {
                tmp.add(a);
            }            
            i++;
        }
        list = tmp;
        //System.out.println(list);
    }
    private void eliminateR2L() {
        LinkedList<Integer> tmp = new LinkedList<>();
        int i = 0;
        while (list.size() != 0) {
            int a = list.removeLast();
            if (i % 2 != 0) {
                tmp.addFirst(a);
            }            
            i++;
        }
        list = tmp;
        //System.out.println(list);
    }
}

