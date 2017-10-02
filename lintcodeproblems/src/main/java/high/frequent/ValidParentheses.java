package high.frequent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by chenj240 on 10/1/17.
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * Example
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        System.out.println(solution.isValidParentheses("()[]{}"));
        System.out.println(solution.isValidParentheses("(]"));
        System.out.println(solution.isValidParentheses("]"));

    }

    public class Solution {
        /*
         * @param s: A string
         * @return: whether the string is a valid parentheses
         */
        public boolean isValidParentheses(String s) {
            // write your code here
            if (s == null || s.length() == 0) {
                return false;
            }
            char[] source = s.toCharArray();

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < source.length; i++) {
                if (source[i] == '(' || source[i] == '[' || source[i] == '{') {
                    stack.push(source[i]);
                }
                if (source[i] == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                }
                if (source[i] == ']') {
                    if (stack.isEmpty() ||  stack.pop() != '[') {
                        return false;
                    }
                }
                if (source[i] == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}
