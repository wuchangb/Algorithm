package programmers.lv3.아이템줍기;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int[][] graph = new int[102][102];
    static boolean[][] visited = new boolean[102][102];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        //그래프 만들기
        for (int i = 0; i < rectangle.length; i++) {
            int[] rect = rectangle[i];
            makeMap(rect);
        }

        int answer = bfs(characterX*2, characterY*2, itemX*2, itemY*2);

        return answer/2;
    }

    static int bfs(int r, int c, int endR, int endC) {
        int cnt = Integer.MAX_VALUE;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(r, c,0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visited[node.r][node.c] = true;
            if (node.r == endR && node.c == endC) {
                cnt = Math.min(cnt, node.step);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int R = node.r + dx[i];
                int C = node.c + dy[i];
                if (R > 100 || R < 1 || C > 100 || C < 1) continue;
                if (!visited[R][C] && graph[R][C] == 1) {
                    visited[R][C] = true;
                    queue.add(new Node(R, C, node.step + 1));
                }
            }
        }
        return cnt;
    }

    static void makeMap(int[] rectangle) {
        int r1 = rectangle[0]*2;
        int c1 = rectangle[1]*2;
        int r2 = rectangle[2]*2;
        int c2 = rectangle[3]*2;

        //가로줄 채우기
        for (int i = c1; i <= c2; i++) {
            if (graph[r1][i] != -1) {
                graph[r1][i] = 1;
            }
            if (graph[r2][i] != -1) {
                graph[r2][i] = 1;
            }
        }
        //세로줄 채우기
        for (int i = r1; i <=r2 ; i++) {
            if (graph[i][c1] != -1) {
                graph[i][c1] = 1;
            }
            if (graph[i][c2] != -1) {
                graph[i][c2] = 1;
            }
        }
        //사각형 안쪽 -1로 채우기
        for (int i = r1+1; i < r2; i++) {
            for (int j = c1 + 1; j < c2; j++) {
                graph[i][j] = -1;
            }
        }
    }

    static class Node {
        int r;
        int c;
        int step;

        public Node(int r, int c, int step) {
            this.r = r;
            this.c = c;
            this.step = step;
        }
    }
}