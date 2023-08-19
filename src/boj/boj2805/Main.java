package boj.boj2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(search(arr, 0, 2000000000, M));


    }

    static long search(int[] arr, int L, int R, int M) {
        int ans = 0;
        while (L <= R) {
            int mid = (L+R)/2;
            long sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > mid) {
                    sum += arr[i] - mid;
                }
            }

            if (sum >= M) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        return ans;
    }
}
