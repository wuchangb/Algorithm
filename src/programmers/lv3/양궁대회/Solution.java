package programmers.lv3.양궁대회;

class Solution {

    static int answer,N;
    static int[] apich, lion;
    static int max;
    public int[] solution(int n, int[] info) {
        N = n;
        apich = info;
        max = -1;
        dfs(0, new int[11],0);
        if (max <= 0) return new int[]{-1};
        else return lion;
    }

    static void dfs(int cnt, int[] result, int start) {
        if (cnt == N) {
            int diff = calculate(result);
            if (diff > max) {
                lion = result;
                max = diff;
            } else if (diff == max) {
                for (int i = 10; i >= 0; i--) {
                    if (result[i] > lion[i]) {
                        lion = result;
                        max = diff;
                    } else if (result[i] < lion[i]) {
                        return;
                    }
                }
            }
            return;
        } else {
            for (int i = start; i < 11; i++) {
                result[i]++;
                dfs(cnt+1, result,i);
                result[i]--;
            }
        }
    }

    static int calculate(int[] result) {
        int lSum = 0;
        int aSum = 0;
        for (int i = 0; i < 11; i++) {
            if (result[i] > apich[i]) {
                lSum += 10 - i;
            } else {
                aSum += 10 - i;
            }
        }
        return lSum - aSum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 9;
        int[] info = {0,0,1,2,0,1,1,1,1,1,1};
        System.out.println(sol.solution(n,info));
    }
}