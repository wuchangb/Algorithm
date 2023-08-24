package programmers.lv2.모음사전;

import java.util.ArrayList;
import java.util.Collections;

class Solution {

    static ArrayList<String> list = new ArrayList<>();
    static String[] arr = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        brute(0,"");
        Collections.sort(list);
        int idx = list.indexOf(word);
        return idx+1;
    }

    public void brute(int idx, String word) {
        if (idx == 5) {
            return;
        }
        for (int i = 0; i < 5; i++) {
            String s = word + arr[i];
            list.add(s);
            brute(idx + 1, s);
        }
    }
}