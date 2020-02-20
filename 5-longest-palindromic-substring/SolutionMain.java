class SolutionMain{
    public static void main(String[] args) {
        Solution ss = new Solution();
        String testStr = "absjkfeisjdaffadjkkkkkkkk"; //8k
        String resultStr = ss.longestPalindrome(testStr);
        System.out.printf("The longest is %s\n",resultStr); // input sysout, it can auto-complete!
    }
}