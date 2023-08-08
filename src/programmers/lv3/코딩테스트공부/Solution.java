package programmers.lv3.코딩테스트공부;

import java.util.Arrays;

public class Solution {

    int[][] dp;
    public int solution(int alp, int cop, int[][] problems) {
        int maxA=0;
        int maxC=0;

        for (int i = 0; i < problems.length; i++) {
            maxA = Math.max(problems[i][0], maxA);
            maxC = Math.max(problems[i][1], maxC);
        }

        dp = new int[maxA + 1][maxC + 1];
        alp = Math.min(alp, maxA);
        cop = Math.min(cop, maxC);
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],100000);
        }

        dp[alp][cop] = 0;

        for (int i = alp; i <= maxA; i++) {
            for (int j = cop; j <= maxC; j++) {
                if (i + 1 <= maxA) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                }
                if (j + 1 <= maxC) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                }

                for (int[] problem : problems) {
                    if (problem[0] <= i && problem[1] <= j) {
                        int nextA = Math.min(maxA, i + problem[2]);
                        int nextC = Math.min(maxC, j + problem[3]);
                        dp[nextA][nextC] = Math.min(dp[nextA][nextC], dp[i][j] + problem[4]);
                    }
                }
            }
        }

        return dp[maxA][maxC];
    }
}
