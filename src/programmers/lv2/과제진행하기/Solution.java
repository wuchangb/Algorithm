package programmers.lv2.과제진행하기;

import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        PriorityQueue<Subject> pq = new PriorityQueue<>();
        Stack<Subject> stack = new Stack<>();
        List<String> list = new ArrayList<>();

        //과제들 추가
        for (int i = 0; i < plans.length; i++) {
            pq.add(new Subject(plans[i][0], getTime(plans[i][1].split(":")), Integer.parseInt(plans[i][2])));
        }

        while (!pq.isEmpty()) {
            Subject cur = pq.poll();
            String name = cur.name;
            int time = cur.time;
            int remain = cur.remain;

            //과제가 더 없는경우
            if (pq.isEmpty()) {
                if (stack.isEmpty()) {      //스택도 다 비운경우
//                    time += remain;
                    list.add(name);
                } else {                    //스택 남아있는경우
                    list.add(name);
                    while (!stack.isEmpty()) {
                        Subject next = stack.pop();
                        list.add(next.name);
                    }
                }
            }
            //과제 남은경우
            else {
                Subject next = pq.peek();
                if (time + remain < next.time) {        //현 과제 끝내도 다음 과제 시작까지 시간 남음
                    list.add(name);
                    time = time + remain;

                    while (!stack.isEmpty()) {
                        Subject tmp = stack.peek();
                        if (time + tmp.remain <= next.time) {
                            time = time + tmp.remain;
                            list.add(tmp.name);
                            stack.pop();
                        } else {
                            int tmpRemain = tmp.remain - (next.time - time);
                            tmp.remain = tmpRemain;
                            break;
                        }
                    }
                } else if (time + remain == next.time) {        //현 과제 끝나는 시간 = 다음과제 시작시간
                    list.add(name);
                } else {        //현 과제를 다음 과제 시작 전까지 못끝내는경우
                    int minus = next.time - time;
                    stack.push(new Subject(name, remain - minus));
                }
            }
        }

        String[] answer = list.stream().toArray(String[]::new);
        return answer;
    }

    static int getTime(String[] arr) {
        int h = Integer.parseInt(arr[0]);
        int t = Integer.parseInt(arr[1]);
        return h*60 + t;
    }

    static class Subject implements Comparable<Subject> {
        String name;
        int time;
        int remain;
        public Subject(String name, int time, int remain) {
            this.name = name;
            this.time = time;
            this.remain = remain;
        }

        public Subject(String name, int remain) {
            this.name = name;
            this.remain = remain;
        }

        @Override
        public int compareTo(Subject o) {
            return this.time - o.time;
        }
    }
}