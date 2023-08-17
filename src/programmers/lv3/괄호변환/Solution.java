package programmers.lv3.괄호변환;

class Solution {
    public String solution(String p) {
        String answer = change(p);

        return answer;
    }

    public String change(String p) {
        if (p.isEmpty()) return "";
        int L = 0;
        int R = 0;
        String u = "";
        String v = "";

        //u,v로 쪼개기
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                L++;
            } else {
                R++;
            }

            if (L == R) {
                u = p.substring(0, L + R);
                v = p.substring(L + R);
                break;
            }
        }

        if (isCorrect(u)) {
            v = change(v);
            return u + v;
        } else {
            String res = "(";
            res += change(v);
            res += ")";
            u = u.substring(1, u.length() - 1);
            res += reverse(u);
            return res;
        }

    }

    static boolean isCorrect(String p) {
        int L = 0;
        int R = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') L++;
            else R++;
            if (L < R) return false;
        }
        return true;
    }

    static String reverse(String p) {
        String res = "";
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') res += ")";
            else res += "(";
        }

        return res;
    }
}