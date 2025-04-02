package codility;

class Solution {
    public int[] solution(int[] A, int K) {

        if(A.length == 0) return A;

        K = K % A.length;
        int start = A.length - K;
        int[] answer = new int[A.length];

        for(int i = start; i < A.length; i++) {
            answer[i - start] = A[i];
        }

        for(int i = 0; i < start; i++) {
            answer[A.length - start + i] = A[i];
        }

        return answer;
    }
}
