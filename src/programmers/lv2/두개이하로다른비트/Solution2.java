package programmers.lv2.두개이하로다른비트;

public class Solution2 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            answer[i] = func(numbers[i]);
        }

        return answer;
    }

    public long func(long num) {
        if (num % 2 == 0) return num+1;

        StringBuilder s = new StringBuilder(Long.toBinaryString(num));
        int n = s.length();
        if (s.toString().contains("01")) {
            for (int i = n; i > 0 ; i--) {
                if (s.substring(i - 2, i).equals("01")) {
                    s.setCharAt(i-1,'0');
                    s.setCharAt(i-2,'1');
                    break;
                }
            }
        } else {
            s.deleteCharAt(0);
            s.insert(0, "10");
        }

        return Long.valueOf(s.toString(), 2);
    }
}
