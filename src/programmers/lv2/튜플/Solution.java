package programmers.lv2.튜플;

import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(String s) {
        ArrayList<Integer> list = new ArrayList<>();

        String[] split = s.split("}");

        String first = split[0].substring(2);
        String[] firstArr = first.split(",");

        for (int i = 0; i < firstArr.length; i++) {
            int tmp = Integer.parseInt(firstArr[i]);
            if (!list.contains(tmp)) {
                list.add(tmp);
            }
        }

        for (int i = 1; i < split.length; i++) {
            String str = split[i].substring(2);
            String[] arr = str.split(",");
            for (int j = 0; j < arr.length; j++) {
                int tmp = Integer.parseInt(arr[j]);
                if (!list.contains(tmp)) {
                    list.add(tmp);
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        sol.solution(s);
        ArrayList<Integer> solution = sol.solution(s);
    }
}