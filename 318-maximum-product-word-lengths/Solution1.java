// faster than my first solution, but still slow: 270ms

class Solution {
    public int maxProduct(String[] words) {
        int res = 0;
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            putInMap(map, i, words[i]);
        }
        for (int k = 0; k < words.length; k++) {
            for (int j = k; j < words.length; j++) {
                if (!hasCommonLetters(map, k, j)) {
                    res = Math.max(res, words[k].length() * words[j].length());
                }
            }
        }
        return res;
  
    }

    private boolean hasCommonLetters(Map<Integer, List<Character>> map, int i, int j) {
        List<Character> l1 = map.get(i);
        List<Character> l2 = map.get(j);

        for (Character a : l1) {
            if (l2.contains(a)) return true;
        }

        for (Character b : l2) {
            if (l1.contains(b)) return true;
        }
        return false;
    }

    private void putInMap(Map<Integer, List<Character>> map, int index, String A) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (!list.contains(A.charAt(i))) {
                list.add(A.charAt(i));
            }
        }
        map.put(index, list);
    }
}