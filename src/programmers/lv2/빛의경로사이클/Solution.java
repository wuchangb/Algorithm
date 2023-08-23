package programmers.lv2.빛의경로사이클;

import java.util.ArrayList;

class Solution {
    static int R,C;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static ArrayList<Integer> list = new ArrayList<>();
    static boolean[][][] visited;

    public int[] solution(String[] grid) {
        int[] answer = {};
        R = grid.length;
        C = grid[0].length();
        visited = new boolean[R][C][4];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (int k = 0; k < 4; k++) {
                    if (!visited[i][j][k]) {
                        int res = func(grid, i, j, k);
                        list.add(res);
                    }
                }
            }
        }

        return list.stream().sorted().mapToInt(i->i).toArray();
    }

    static int func(String[] grid, int r, int c, int dir) {
        int cnt = 0;

        while (true) {
            if (visited[r][c][dir]) break;

            cnt++;
            visited[r][c][dir] = true;

            if (grid[r].charAt(c) == 'L') {
                if (dir == 0) dir = 3;
                else dir -= 1;
            } else if (grid[r].charAt(c) == 'R') {
                if (dir == 3) dir = 0;
                else dir += 1;
            }

            r = (r + dr[dir] + R) % R;
            c = (c + dc[dir] + C) % C;
        }
        return cnt;
    }
}