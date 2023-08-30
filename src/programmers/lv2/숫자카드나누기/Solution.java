package programmers.lv2.숫자카드나누기;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int a = arrayA[0];
        int b = arrayB[0];
        for (int i = 1; i < arrayA.length; i++) {
            a = euclid(a, arrayA[i]);
            b = euclid(b, arrayB[i]);
        }

        if (a == 1 && b == 1) return 0;

        if (possible(arrayA, b)) {
            answer = Math.max(answer, b);
        }
        if (possible(arrayB, a)) {
            answer = Math.max(answer, a);
        }

        return answer;
    }

    public int euclid(int a, int b) {
        int A = Math.max(a, b);
        int B = Math.min(a, b);
        if (A%B == 0) return B;
        else return euclid(B, A % B);
    }

    public boolean possible(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % num == 0) return false;
        }
        return true;
    }
}