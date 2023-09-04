package boj.boj14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visited;
    static int[][] graph;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer++;
        dfs(r, c, d);

        System.out.println(answer);
    }

    static void dfs(int r, int c, int d) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            d = getDir(d);
            int rr = r + dr[d];
            int cc = c + dc[d];
            if (!possible(rr,cc)) continue;
            if (!visited[rr][cc] && graph[rr][cc] == 0) {
                answer++;
                dfs(rr, cc, d);
                return;
            }
        }

        int rr = r - dr[d];
        int cc = c - dc[d];
        if (possible(rr, cc) && graph[rr][cc] == 0) {
            dfs(rr,cc,d);
        }
    }

    static boolean possible(int r, int c) {
        if (r < 0 || r >= graph.length || c < 0 || c >= graph[0].length) return false;
        return true;
    }

    static int getDir(int d) {
        if (d == 0) return 3;
        else return d - 1;
    }
}
