package programmers.lv2.행렬테두리회전하기;

class Solution {

    static int[][] map;

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        map = new int[rows + 1][columns + 1];
        int tmp = 1;

        for (int i = 1; i <= rows ; i++) {
            for (int j = 1; j <= columns ; j++) {
                map[i][j] = tmp++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            answer[i] = turn(queries[i]);
        }

        return answer;
    }

    public int turn(int[] arr) {
        int r1 = arr[0];
        int c1 = arr[1];
        int r2 = arr[2];
        int c2 = arr[3];
        int min = 10001;

        int tmp = map[r1][c2];  //우측상단
        min = Math.min(min, tmp);
        //윗줄
        for (int i = c2; i > c1 ; i--) {
            map[r1][i] = map[r1][i - 1];
            min = Math.min(min, map[r1][i]);
        }

        //왼쪽줄
        for (int i = r1; i < r2; i++) {
            map[i][c1] = map[i + 1][c1];
            min = Math.min(min, map[i][c1]);
        }

        //아랫줄
        for (int i = c1; i <c2 ; i++) {
            map[r2][i] = map[r2][i + 1];
            min = Math.min(min, map[r2][i]);
        }

        //오른쪽줄
        for (int i = r2; i > r1; i--) {
            map[i][c2] = map[i - 1][c2];
            min = Math.min(min, map[i][c2]);
        }

        map[r1+1][c2] = tmp;

        return min;
    }
}