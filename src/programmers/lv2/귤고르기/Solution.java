package programmers.lv2.귤고르기;

import java.util.*;

public class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        for (Integer key : map.keySet()) {
            list.add(map.get(key));
        }

        Collections.sort(list, Collections.reverseOrder());

        while (k > 0) {
            k -= list.get(answer);
            answer++;
        }

        return answer;
    }
}
