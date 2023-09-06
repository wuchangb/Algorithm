package boj.boj3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static boolean[][] apple;
    static boolean[][] snake;
    static HashMap<Integer, String> map = new HashMap<>();
    static int N;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};    //북동남서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        apple = new boolean[N + 1][N + 1];
        snake = new boolean[N + 1][N + 1];

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");
            apple[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = true;
        }

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            String[] s = br.readLine().split(" ");
            map.put(Integer.parseInt(s[0]), s[1]);
        }

        System.out.println(move());
    }

    static int move() {
        int res = 0;
        int r = 1;
        int c = 1;
        int d = 1;  //방향
        snake[1][1] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 1});
        while (true) {
            if (map.containsKey(res)) {
                String s = map.get(res);
                if (s.equals("L")) {
                    d = d == 0 ? 3 : d - 1;
                } else {
                    d = d == 3 ? 0 : d + 1;
                }
            }

            res++;
            int rr = r + dir[d][0];
            int cc = c + dir[d][1];

            if (!possible(rr,cc) || snake[rr][cc]) break;

            snake[rr][cc] = true;
            q.add(new int[]{rr, cc});

            if (!apple[rr][cc]) {
                int[] poll = q.poll();
                snake[poll[0]][poll[1]] = false;
            } else {
                apple[rr][cc] = false;
            }

            r = rr;
            c = cc;
        }

        return res;
    }

    static boolean possible(int r, int c) {
        if (r<=0 || r>N || c<=0 || c>N) return false;
        return true;
    }
}
