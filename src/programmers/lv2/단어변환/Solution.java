package programmers.lv2.단어변환;

class Solution {

    static int answer = 11;
    static String target;
    static String[] arr;
    static boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        arr = new String[words.length];
        this.target = target;
        visited = new boolean[words.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = words[i];
        }

        dfs(begin,0);

        if(answer == 11) answer = 0;

        return answer;
    }

    public void dfs(String word, int idx) {

        if (word.equals(target)) {
            answer = Math.min(answer, idx);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (possible(word, arr[i]) && !visited[i]) {
                visited[i] = true;
                dfs(arr[i], idx + 1);
                visited[i] = false;
            }
        }
    }

    public boolean possible(String word, String next) {
        int cnt = 0;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            if (word.charAt(i) != next.charAt(i)) cnt++;
            if (cnt > 1) return false;
        }
        return true;
    }
}