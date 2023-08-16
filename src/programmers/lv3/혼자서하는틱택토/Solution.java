package programmers.lv3.혼자서하는틱택토;

class Solution {

    static char[][] map = new char[3][3];

    public int solution(String[] board) {
        int answer = 0;
        int cntO = 0;
        int cntX = 0;
        for (int i = 0; i < 3; i++) {
            String s = board[i];
            for (int j = 0; j < 3; j++) {
                char tmp = s.charAt(j);
                if (tmp == 'O') cntO++;
                if (tmp == 'X') cntX++;
                map[i][j] = tmp;
            }
        }

        if(cntO - cntX > 1 || cntO - cntX <0) return 0;

        if (row('O') || col('O') || cross('O')) {
            if (row('X') || col('X') || cross('X')) return 0;
            if (cntO > cntX) return  1;
            return 0;
        } else if (row('X') || col('X') || cross('X')) {
            if (row('O') || col('O') || cross('O')) return 0;
            if (cntO == cntX) return  1;
            return 0;
        }

        return 1;
    }

    //가로
    public boolean row(char c) {
        for (int i = 0; i < map.length; i++) {
            if (map[i][0] == c && map[i][1] ==c && map[i][2] == c) return true;
        }
        return false;
    }

    //세로
    public boolean col(char c) {
        for (int i = 0; i < map[0].length; i++) {
            if (map[0][i] == c && map[1][i] == c && map[2][i] == c) return true;
        }
        return false;
    }

    //대각선
    public boolean cross(char c) {
        if (map[0][0] == c && map[1][1] == c && map[2][2] == c) return true;
        if (map[0][2] == c && map[1][1] == c && map[2][0] == c) return true;
        return false;
    }

    public static void main(String[] args) {
        String[] board = {"O.X", ".O.", "..X"};
        Solution sol = new Solution();
        sol.solution(board);
    }
}