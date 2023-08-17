package programmers.lv2.멀쩡한사각형;

class Solution {
    public long solution(int w, int h) {
        long answer = w*h;
        double r = (double) h/w;

        long gcd = euclid(w, h);

        return (long)w*h - (w/gcd + h/gcd -1)*gcd;
    }

    public int euclid(int a, int b) {
        if (b == 0) return a;
        return euclid(b, a % b);
    }

    public static void main(String[] args) {
        int w = 8;
        int h = 12;
        Solution sol = new Solution();
        sol.solution(w, h);
    }
}