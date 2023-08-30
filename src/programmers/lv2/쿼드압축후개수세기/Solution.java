package programmers.lv2.쿼드압축후개수세기;

import java.util.Arrays;
import java.util.Collections;

class Solution {
    static int[] answer = {0, 0};
    public int[] solution(int[][] arr) {
        int len = arr.length;
        quad(arr, 0, 0, len);
        return answer;
    }

    public void quad(int[][] arr, int r, int c, int size) {
        if (same(arr, r, c, size)) {
            int tmp = arr[r][c];
            if (tmp == 1) answer[1]++;
            else answer[0]++;
            return;
        }
        quad(arr,r,c,size/2);
        quad(arr,r+size/2,c,size/2);
        quad(arr,r,c+size/2,size/2);
        quad(arr,r+size/2,c+size/2,size/2);
    }

    public boolean same(int[][] arr, int r,int c, int size) {
        int tmp = arr[r][c];
        for (int i = r; i < r+size ; i++) {
            for (int j = c; j < c+size; j++) {
                if (arr[i][j] != tmp) return false;
            }
        }
        return true;
    }
}