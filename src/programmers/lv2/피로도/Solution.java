package programmers.lv2.피로도;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    static int answer = 0;
    static int K;
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        int length = dungeons.length;
        K = k;
        visited = new boolean[length];
        dfs(0, new int[length][2], dungeons);

        return answer;
    }

    public void dfs(int idx, int[][] arr, int[][] dungeons) {
        if (idx == dungeons.length) {
            cal(arr);
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[idx][0] = dungeons[i][0];
                arr[idx][1] = dungeons[i][1];
                dfs(idx+1,arr,dungeons);
                visited[i] = false;
            }
        }
    }

    public void cal(int[][] arr) {
        int k = K;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (k < arr[i][0]) break;
            k -= arr[i][1];
            res++;
        }
        answer = Math.max(answer, res);
    }
}
