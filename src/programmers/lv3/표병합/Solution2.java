package programmers.lv3.표병합;

import java.util.Stack;

class Solution2 {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> stack = new Stack<>();
        int size = n;
        for (int i = 0; i < cmd.length; i++) {
            String[] s = cmd[i].split(" ");
            if (s[0].equals("D")) {
                k += Integer.parseInt(s[1]);
            } else if (s[0].equals("U")) {
                k -= Integer.parseInt(s[1]);
            } else if (s[0].equals("C")) {
                stack.push(k);
                size--;
                if (size == k) {
                    k--;
                }
            } else {
                if (stack.pop() <= k) {
                    k++;
                }
                size++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("O");
        }

        while (!stack.isEmpty()) {
            sb.insert(stack.pop(), "X");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
        System.out.println(sol.solution(n, k, cmd));

    }
}