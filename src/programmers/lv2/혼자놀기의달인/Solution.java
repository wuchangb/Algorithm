package programmers.lv2.혼자놀기의달인;

class Solution {

    static int answer = 0;
    static boolean[] visited;
    public int solution(int[] cards) {
        visited = new boolean[cards.length];
        for (int i = 0; i < cards.length; i++) {
            dfs(i,0,0,cards,false);
        }
        return answer;
    }

    public void dfs(int next, int first, int second, int[] cards, boolean f) {
        if (first == cards.length) {
            return;
        }

        if (first + second == cards.length) {
            answer = Math.max(answer, first * second);
        }

        if (visited[next]) {
            if (!f) {
                f = true;
                for (int i = 0; i < cards.length; i++) {
                    if (!visited[cards[i] - 1]) {
                        dfs(cards[i] - 1, first, second, cards, f);
                    }
                }
            } else {
                answer = Math.max(answer,first*second);
                return;
            }
        }

        visited[next] = true;
        if (!f) {
            dfs(cards[next] - 1, first + 1, second, cards, f);
        } else {
            dfs(cards[next] - 1, first, second + 1, cards, f);
        }
        visited[next] = false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] cards = {8, 6, 3, 7, 2, 5, 1, 4};
        sol.solution(cards);
    }
}