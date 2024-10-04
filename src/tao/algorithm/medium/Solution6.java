package tao.algorithm.medium;

import java.util.Stack;

public class Solution6 {
    private boolean flag = false;

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        System.out.println(solution6.isValid("()"));
    }

    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.pop() != '(') return false;
                continue;
            }
            if (s.charAt(i) == ']') {
                if (stack.isEmpty() || stack.pop() != '[') return false;
                continue;
            }
            if (s.charAt(i) == '}') {
                if (stack.isEmpty() || stack.pop() != '{') return false;
                continue;
            }
            stack.push(s.charAt(i));
        }
        return stack.empty();
    }
}
