package programmers.lv2.방문길이;

public class Solution {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int answer = 0;
    static int r = 5, c = 5;
    static boolean[][][][] visited = new boolean[11][11][11][11];

    public int solution(String dirs) {

        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            move(c);
        }

        return answer;

    }

    public void move(char C) {
        int dir;
        if (C == 'U') {
            dir = 0;
        } else if (C == 'D') {
            dir = 1;
        } else if (C == 'L') {
            dir = 2;
        } else {
            dir = 3;
        }
        int rr = r + dy[dir];
        int cc = c + dx[dir];
        if (!possible(rr,cc)) return;

        if (!visited[r][c][rr][cc] && !visited[rr][cc][r][c]) {
            visited[r][c][rr][cc] = true;
            visited[rr][cc][r][c] = true;
            answer++;
        }
        r = rr;
        c = cc;
    }

    public boolean possible(int x, int y) {
        if (x<0 || x>10 || y<0 || y>10) return false;
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String dirs = "ULURRDLLU";
        sol.solution(dirs);
    }
}
