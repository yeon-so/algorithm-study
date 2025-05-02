class Solution {
    public int[] solution(int N, int[] A) {
        int[] result = new int[N];
        int cur = 0;
        int max = 0;

        for(int i = 0; i < A.length; i++) {
            if(A[i] <= N) {

                if(cur > 0 && result[A[i]-1] < cur) {
                    result[A[i]-1] = cur;
                }

                result[A[i]-1]++;

                if(max < result[A[i]-1]) {
                    max = result[A[i]-1];
                }
            } else {
                cur = max;
            }
        }

        for(int i = 0; i < result.length; i++) {
            if(cur != 0 && result[i] < cur) {
                result[i] = cur;
            }
        }

        return result;
    }
}