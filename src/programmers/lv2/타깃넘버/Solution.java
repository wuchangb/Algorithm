package programmers.lv2.타깃넘버;

public class Solution {
    static int res = 0;

    public int solution(int[] numbers, int target) {

        dfs(numbers,new int[numbers.length], target, 0);

        return res;
    }

    static void dfs(int[] numbers, int[] answers, int target, int cnt) {
        if (cnt == numbers.length) {
            int tmp = 0;
            for (int i = 0; i < answers.length; i++) {
                tmp += answers[i];
            }
            if (tmp == target) res++;
            return;
        }
        answers[cnt] = numbers[cnt];
        dfs(numbers, answers, target, cnt+1);
        answers[cnt] = -numbers[cnt];
        dfs(numbers,answers,target,cnt+1);
    }
}

