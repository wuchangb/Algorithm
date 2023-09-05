package boj.boj15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Node[] arr;
    static int N,M,res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        res = N*M;
        int[][] graph = new int[N][M];
        int num = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                graph[i][j] = tmp;
                if (tmp != 0 && tmp != 6) num++;
            }
        }

        arr = new Node[num];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] != 0 && graph[i][j] != 6) {
                    arr[idx] = new Node(i, j, graph[i][j]);
                    idx++;
                }
            }
        }

        dfs(0,graph);
        System.out.println(res);
    }

    static void dfs(int idx, int[][] graph) {
        if (idx == arr.length) {
            int tmp = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] == 0) tmp++;
                }
            }
            res = Math.min(res, tmp);
            return;
        }

        Node cur = arr[idx];
        int cctv = cur.cc;
        int r = cur.r;
        int c = cur.c;
        int[][] copy;

        if (cctv == 1) {
            copy = copyG(graph);
            left(r,c,copy);
            dfs(idx + 1, copy);

            copy = copyG(graph);
            right(r,c,copy);
            dfs(idx + 1, copy);

            copy = copyG(graph);
            up(r,c,copy);
            dfs(idx + 1, copy);

            copy = copyG(graph);
            down(r,c,copy);
            dfs(idx + 1, copy);

        } else if (cctv == 2) {
            copy = copyG(graph);
            left(r, c, copy);
            right(r, c, copy);
            dfs(idx + 1, copy);

            copy = copyG(graph);
            up(r, c, copy);
            down(r, c, copy);
            dfs(idx + 1, copy);

        } else if (cctv == 3) {
            copy = copyG(graph);
            left(r, c, copy);
            up(r,c,copy);
            dfs(idx+1,copy);

            copy = copyG(graph);
            up(r, c, copy);
            right(r,c,copy);
            dfs(idx+1,copy);

            copy = copyG(graph);
            right(r, c, copy);
            down(r,c,copy);
            dfs(idx+1,copy);

            copy = copyG(graph);
            down(r, c, copy);
            left(r,c,copy);
            dfs(idx+1,copy);

        } else if (cctv == 4) {
            copy = copyG(graph);
            left(r, c, copy);
            up(r, c, copy);
            right(r, c, copy);
            dfs(idx+1,copy);

            copy = copyG(graph);
            up(r, c, copy);
            right(r, c, copy);
            down(r, c, copy);
            dfs(idx+1,copy);

            copy = copyG(graph);
            right(r, c, copy);
            down(r, c, copy);
            left(r, c, copy);
            dfs(idx+1,copy);

            copy = copyG(graph);
            down(r, c, copy);
            left(r, c, copy);
            up(r, c, copy);
            dfs(idx+1,copy);

        } else if (cctv == 5) {
            copy = copyG(graph);
            left(r, c, copy);
            right(r, c, copy);
            up(r, c, copy);
            down(r, c, copy);
            dfs(idx+1,copy);
        }
    }

    static void left(int r, int c, int[][] graph) {
        for (int i = c-1; i >=0 ; i--) {
            if (graph[r][i] == 6) return;
            if (graph[r][i] == 0) graph[r][i] = -1;
        }
    }

    static void right(int r, int c, int[][] graph) {
        for (int i = c+1; i <M ; i++) {
            if (graph[r][i] == 6) return;
            if (graph[r][i] == 0) graph[r][i] = -1;
        }
    }

    static void up(int r, int c, int[][] graph) {
        for (int i = r-1; i >=0 ; i--) {
            if (graph[i][c] == 6) return;
            if (graph[i][c] == 0) graph[i][c] = -1;
        }
    }

    static void down(int r, int c, int[][] graph) {
        for (int i = r+1; i < N ; i++) {
            if (graph[i][c] == 6) return;
            if (graph[i][c] == 0) graph[i][c] = -1;
        }
    }

    static int[][] copyG(int[][] graph) {
        int[][] copy = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                copy[i][j] = graph[i][j];
            }
        }
        return copy;
    }

    static boolean possible(int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= M) return false;
        else return true;
    }
    static class Node {
        int r;
        int c;
        int cc;

        public Node(int r, int c, int cc) {
            this.r = r;
            this.c = c;
            this.cc = cc;
        }
    }
}
