import java.util.Stack;

// Note that the class name is Solution1!!
class Solution1 {
    public String decodeString(String s) {
        if (s.length() <= 1) return s;
        Stack<Integer> nums = new Stack<>();
        Stack<String> strs = new Stack<>();

        int p1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).matches("[0-9]")) {
                p1 = i;
                while (i < s.length() && String.valueOf(s.charAt(i)).matches("[0-9]")) i++;
                nums.push(Integer.valueOf(s.substring(p1, i))); // index = i is not inclusive
                i--;
            }
            if (String.valueOf(s.charAt(i)).matches("[a-zA-Z]")) {
                p1 = i;
                while (i < s.length() && String.valueOf(s.charAt(i)).matches("[a-zA-Z]")) i++;
                strs.push(s.substring(p1, i)); // index = i is not inclusive
                i--;
            }
            if (s.charAt(i) == '[') {
                strs.push("[");
            }

            if (s.charAt(i) == ']') {
                String str = "";
                while (!strs.peek().equals("[")) {
                    str = strs.pop() + str;
                }
                strs.pop();
                //System.out.println(str);

                int num = nums.pop();
                String repeat = "";
                while (num > 0) {
                    repeat += str;
                    num--;
                }
                strs.push(repeat);
            }
        }
        String res = "";
        while (!strs.isEmpty()) {
            res = strs.pop() + res;
        }
        return res;

    }
}
