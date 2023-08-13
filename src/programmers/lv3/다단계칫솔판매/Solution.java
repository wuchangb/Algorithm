package programmers.lv3.다단계칫솔판매;

import java.util.HashMap;
import java.util.Map;

class Solution {

    static Map<String, String> parent;
    static Map<String, Integer> map;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        parent = new HashMap<>();
        map = new HashMap<>();

        //돈셋팅
        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], 0);
        }

        //부모세팅
        for (int i = 0; i < referral.length; i++) {
            if (referral[i].equals("-")) {
                parent.put(enroll[i], ".");
            } else {
                parent.put(enroll[i], referral[i]);
            }
        }

        for (int i = 0; i < seller.length; i++) {
            String person = seller[i];
            int money = amount[i]*100;

            while (money > 0 && !person.equals(".")) {
                int tmp = (int) Math.ceil(money * 0.9);
                money = money - tmp;
                map.replace(person, map.get(person) + tmp);
                person = parent.get(person);
            }
        }

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = map.get(enroll[i]);
        }
        return answer;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        sol.solution(enroll, referral, seller, amount);
    }
}