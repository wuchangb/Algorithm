package programmers.lv3.rhkdrh;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int play = seconds(play_time);
        int adv = seconds(adv_time);
        int[] table = new int[play + 1];

        for (int i = 0; i < logs.length; i++) {
            String[] split = logs[i].split("-");
            int start = seconds(split[0]);
            int end = seconds(split[1]);
            for (int j = start; j <= end ; j++) {
                table[j]++;
            }
        }


        return answer;
    }

    public int seconds(String time) {
        int res = 0;
        String[] split = time.split(":");
        res += Integer.parseInt(split[0]) * 3600;
        res += Integer.parseInt(split[1]) * 60;
        res += Integer.parseInt(split[3]);

        return res;
    }
}