package programmers.lv2.이진변환반복하기;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        StringBuilder sb = new StringBuilder(s);
        while (!sb.toString().equals("1")) {
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '0') {
                    answer[1]++;
                    sb.deleteCharAt(i);
                    i--;
                }
            }
            if (sb.toString().equals("1")) break;
            int len = sb.length();
            sb = new StringBuilder(Integer.toBinaryString(len));
            answer[0]++;
        }
        answer[0]++;
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("110010101001");
    }
}