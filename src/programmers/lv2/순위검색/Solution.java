package programmers.lv2.순위검색;

import java.util.*;

class Solution {

    static Map<String, ArrayList<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for (int i = 0; i < info.length; i++) {
            String[] s = info[i].split(" ");
            makeString(s, "", 0);
        }

        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] s = query[i].split(" ");
            if (!map.containsKey(s[0])) answer[i] = 0;
            else answer[i] = binarySearch(s[0], Integer.parseInt(s[1]));
        }

        return answer;
    }

    public int binarySearch(String key, int score) {
        ArrayList<Integer> list = map.get(key);
        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int mid = (start + end)/2;
            if (list.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return list.size() - start;
    }

    public static void makeString(String[] s, String string, int cnt) {
        if (cnt == 4) {
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList<>());
            }
            map.get(string).add(Integer.parseInt(s[4]));
            return;
        }

        makeString(s, string + s[cnt], cnt + 1);
        makeString(s, string + "-", cnt + 1);
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

        sol.solution(info, query);
    }
}