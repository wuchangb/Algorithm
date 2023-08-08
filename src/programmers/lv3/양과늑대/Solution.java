package programmers.lv3.양과늑대;


class Solution {

    static int max = -1;
    static int[] info;
    static int[][] edges;

    public int solution(int[] info, int[][] edges) {
        this.info = info;
        this.edges = edges;
        boolean[] visited = new boolean[info.length];

        dfs(0, 0, 0, visited);

        return max;
    }

    static void dfs(int idx, int ship, int wolf, boolean[] visited) {
        visited[idx] = true;
        if (info[idx] == 0) {
            ship++;
            max = Math.max(max, ship);
        } else {
            wolf++;
        }

        if (wolf >= ship) return;

        for (int[] edge : edges) {
            if (visited[edge[0]] && !visited[edge[1]]) {
                boolean[] nextVisited = new boolean[info.length];
                for (int i = 0; i < nextVisited.length; i++) {
                    nextVisited[i] = visited[i];
                }
                dfs(edge[1],ship,wolf,nextVisited);
            }
        }
    }
}