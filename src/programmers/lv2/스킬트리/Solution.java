package programmers.lv2.스킬트리;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

    static Set<Character> set = new HashSet<>();

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < skill.length(); i++) {
            q.add(skill.charAt(i));
            set.add(skill.charAt(i));
        }

        for (int i = 0; i < skill_trees.length; i++) {
            if (possible(q, skill_trees[i])) {
                answer++;
            }
        }

        return answer;
    }

    public boolean possible(Queue<Character> q, String skill) {
        Queue<Character> newQ = new LinkedList<>();
        newQ.addAll(q);

        for (int i = 0; i < skill.length(); i++) {
            char c = skill.charAt(i);
            if (set.contains(c)) {
                if (newQ.isEmpty()) continue;
                if (newQ.peek().equals(c)) {
                    newQ.poll();
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(sol.solution(skill, skill_trees));

    }
}
