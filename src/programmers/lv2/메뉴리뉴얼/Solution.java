package programmers.lv2.메뉴리뉴얼;

import java.util.*;

class Solution {

    static HashMap<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        for (String order : orders) {
            order = sort(order);
            dfs(new boolean[order.length()], order, 0, course);
        }
        List<String> keyList = new ArrayList<>(map.keySet());
        for (int i = 0; i < keyList.size(); i++) {
            String key = keyList.get(i);
            if (map.get(key) < 2) {
                keyList.remove(i--);
                continue;
            }
            for (int len : course) {
                if (key.length() != len) continue;
                for (int j = 0; j < i; j++) {
                    String before = keyList.get(j);
                    if (key.length() != before.length()) continue;
                    if (map.get(key) < map.get(before)) {
                        keyList.remove(i--);
                        break;
                    } else if (map.get(key) > map.get(before)) {
                        keyList.remove(j--);
                        i--;
                    }
                }
            }
        }
        Collections.sort(keyList);
        return keyList.stream().toArray(String[]::new);
    }

    public void dfs(boolean[] visited, String order, int cnt, int[] course) {
        if (cnt == order.length()) {
            String menu = "";
            for (int i = 0; i < order.length(); i++) {
                if (visited[i]) {
                    menu += order.charAt(i);
                }
            }
            if (menu.length() < 2) return;
            for (int c : course) {
                if (menu.length() == c) {
                    map.put(menu, map.getOrDefault(menu, 0) + 1);
                }
            }
        } else {
            visited[cnt] = true;
            dfs(visited, order, cnt + 1, course);
            visited[cnt] = false;
            dfs(visited, order, cnt + 1, course);
        }
    }

    public String sort(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }
}