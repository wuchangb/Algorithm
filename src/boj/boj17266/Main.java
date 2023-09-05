package boj.boj17266;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashSet<Integer> set = new HashSet<>();
        int left = arr[0]-1;
        int right = N;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(mid)) {
                right = mid - 1;
            } else {
                left = mid+1;
            }
        }

        System.out.println(left);
    }

    static boolean isPossible(int h) {
        int pre = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - h <= pre) {
                pre = arr[i] + h;
            } else {
                return false;
            }
        }
        return N - pre <= 0;
    }
}
