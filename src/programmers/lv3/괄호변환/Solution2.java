package programmers.lv3.괄호변환;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc")); // 2a2ba3c
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));
    }

    public static int solution(String s) {
        StringBuilder sb;
        int ans = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            sb = new StringBuilder();
            int j = 0;
            while (true) {
                int k = 1;
                int start = i * j;
                int end = start + i;
                if (end >= s.length()) {
                    if (start < s.length())
                        sb.append(s.substring(start));
                    break;
                }
                String cmp = s.substring(start, end);
                while (true) {
                    if (s.substring(start + i * k).startsWith(cmp))
                        k++;
                    else
                        break;
                }
                if (k >= 2) {
                    sb.append(k).append(cmp);
                } else {
                    sb.append(cmp);
                }
                j += k;
            }
            ans = Math.min(ans, sb.length());
        }
        return ans;
    }
}