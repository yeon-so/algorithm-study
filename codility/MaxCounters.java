class Solution {
    public int[] solution(int N, int[] A) {
        int[] result = new int[N];
        int min = 0;
        int max = 0;

        for(int i = 0; i < A.length; i++) {
            if(A[i] <= N) {

                if(min > 0 && result[A[i]-1] < min) {
                    result[A[i]-1] = min;
                }

                result[A[i]-1]++;

                if(max < result[A[i]-1]) {
                    max = result[A[i]-1];
                }
            } else {
                min = max;
            }
        }

        for(int i = 0; i < result.length; i++) {
            if(min != 0 && result[i] < min) {
                result[i] = min;
            }
        }

        return result;
    }
}