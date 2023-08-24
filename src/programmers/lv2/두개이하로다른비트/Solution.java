package programmers.lv2.두개이하로다른비트;

public class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            answer[i] = func(numbers[i]);
        }

        return answer;
    }

    public long func(long num) {
        String s = Long.toBinaryString(num);

        while (true) {
            num++;
            String tmp = Long.toBinaryString(num);
            if (isPossible(s, tmp)) break;
        }

        return num;
    }

    public boolean isPossible(String s1, String s2) {
        int max = Math.max(s1.length(), s2.length());
        int min = Math.min(s1.length(), s2.length());
        int cnt = max - min;
        if (cnt > 2) return false;

        for (int i = 0; i < min; i++) {
            if (s1.charAt(s1.length() - 1 - i) != s2.charAt(s2.length() - 1 - i)) cnt++;
            if (cnt > 2) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new long[]{2, 7}));
    }
}
