class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        if (!haystack.contains(needle)) return -1;

        int count = 0;
        int len = needle.length();

        String temp = haystack.substring(0, len);
        

        while (!temp.contains(needle)) {
            count ++;
            temp = haystack.substring(count, len + count);
        }
        return count;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        
        String hay = "aabbccderthjertllert";
        String needle = "ert";
        int index = s.strStr(hay,needle);
        System.out.println(index);
    }
}