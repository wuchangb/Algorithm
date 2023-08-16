package programmers.lv3.합승택시요금;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    static int[] startA,startB,start;
    static ArrayList<Edge>[] list;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        startA = new int[n + 1];
        startB = new int[n + 1];
        start = new int[n + 1];
        list = new ArrayList[n + 1];

        for (int i = 1; i <=n ; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < fares.length; i++) {
            int A = fares[i][0];
            int B = fares[i][1];
            int C = fares[i][2];
            list[A].add(new Edge(B, C));
            list[B].add(new Edge(A, C));
        }

        Arrays.fill(startA,Integer.MAX_VALUE);
        Arrays.fill(startB,Integer.MAX_VALUE);
        Arrays.fill(start,Integer.MAX_VALUE);

        int[] A = dij(a, startA);
        int[] B = dij(b, startB);
        int[] total = dij(s, start);

        int answer = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, A[i] + B[i] + total[i]);
        }

        return answer;
    }

    static int[] dij(int s, int[] arr) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(s, 0));
        arr[s] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.volume>arr[cur.idx]) continue;

            for (Edge next : list[cur.idx]) {
                if (arr[next.idx] > arr[cur.idx] + next.volume) {
                    arr[next.idx] = arr[cur.idx] + next.volume;
                    pq.add(new Edge(next.idx, arr[cur.idx] + next.volume));
                }
            }
        }

        return arr;
    }


    static class Edge implements Comparable<Edge> {
        int idx;
        int volume;

        public Edge(int idx, int volume) {
            this.idx = idx;
            this.volume = volume;
        }

        @Override
        public int compareTo(Edge o) {
            return this.volume - o.volume;
        }
    }



}