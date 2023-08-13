package programmers.lv3.카드짝맞추기;

class Solution {

    static int answer = Integer.MAX_VALUE;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map = new int[4][4];
    public int solution(int[][] board, int r, int c) {

        //맵복사
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                map[i][j] = board[i][j];
            }
        }

        //제거해야할 카드짝 수 구하기
        int card = 0;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (board[i][j] != 0) {
                    card++;
                }
            }
        }

        dfs(r, c, 0, card/2,-1);
        return answer;
    }

    static void dfs(int r, int c, int cnt, int card, int tmp) {

        //카드 안열었고, 현재 좌표에 카드가 있다면 enter
        if (tmp == -1 && map[r][c] != 0) {
            cnt++;
            tmp = map[r][c];
        }

        //현재 좌표가 tmp 값과 같으면 카드 제거
        if (tmp == map[r][c]) {
            cnt++;
            card--;
            erase(tmp);
            tmp = -1;
        }

        if (card == 0) {
            answer = Math.max(answer, cnt);
            return;
        }

        //ctrl 옮기기
        for (int i = 0; i < 4; i++) {
            int[] control = control(i, r, c);
            int R = control[0];
            int C = control[1];
            if (R>3 || R<0 || C>3 || C<0) continue;
            if (R != r && C != c) {
                dfs(R,C,cnt+1, card, tmp);
            }
        }

        //그냥 옮기기
        for (int i = 0; i < 4; i++) {
            int R = r + dx[i];
            int C = c + dy[i];
            if (R>3 || R<0 || C>3 || C<0) continue;
            dfs(R, C, cnt + 1, card, tmp);
        }
    }

    //ctrl 움직임
    static int[] control(int idx, int r, int c) {
        if (idx == 0) { //위
            while (r-1 >= 0) {
                r--;
                if (map[r][c] != 0) break;
            }
        } else if (idx == 1) {  //아래
            while (r + 1 <= 3) {
                r++;
                if (map[r][c] != 0) break;
            }
        } else if (idx == 2) {  //오른쪽
            while (c + 1 <= 3) {
                c++;
                if (map[r][c] != 0) break;
            }
        } else {  //왼쪽
            while (c - 1 >= 0) {
                c--;
                if (map[r][c] != 0) break;
            }
        }
        return new int[]{r, c};
    }

    //카드 지우기
    static void erase(int idx) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (map[i][j] == idx) {
                    map[i][j] = 0;
                }
            }
        }
    }
}