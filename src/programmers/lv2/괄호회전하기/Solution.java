package programmers.lv2.괄호회전하기;

import java.util.Stack;

public class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();

        if (isCorrect(s)) answer++;

        for (int i = 1; i < len; i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            if (isCorrect(right + left)) answer++;
        }

        return answer;
    }

    public boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ']' && !stack.isEmpty() && stack.peek() == '[') stack.pop();
            else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') stack.pop();
            else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') stack.pop();
            else stack.push(c);
        }
        if (stack.isEmpty()) return true;
        else return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("[](){}");
    }
}
