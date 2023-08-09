package programmers.lv3.파괴되지않은건물;

class Solution {

    static int[][] sum; //누적합
    static int N,M;
    public int solution(int[][] board, int[][] skill) {
        N = board.length;
        M = board[0].length;
        sum = new int[N + 1][M + 1];

        for (int i = 0; i < skill.length; i++) {
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];

            if (type == 1) {     //공격인경우
                sum[r1][c1] += -degree;
                sum[r2 + 1][c1] += degree;
                sum[r1][c2 + 1] += degree;
                sum[r2 + 1][c2 + 1] += -degree;
            } else {    //회복인경우
                sum[r1][c1] += degree;
                sum[r2 + 1][c1] += -degree;
                sum[r1][c2 + 1] += -degree;
                sum[r2 + 1][c2 + 1] += degree;
            }
        }

        func(); //누적합 계산

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (sum[i][j] + board[i][j]> 0) answer++;
            }
        }
        return answer;
    }

    static void func() {

        //가로합
        for (int i = 0; i < N+1; i++) {
            int total = 0;
            for (int j = 0; j < M+1; j++) {
                total += sum[i][j];
                sum[i][j] = total;
            }
        }

        //세로합
        for (int i = 0; i < M; i++) {
            int total = 0;
            for (int j = 0; j < N; j++) {
                total += sum[j][i];
                sum[j][i] = total;
            }
        }
    }
}