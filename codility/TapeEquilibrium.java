package codility;

public class TapeEquilibrium {
    class Solution { // 누적합 - O(N)
        public int solution(int[] A) {
            int a = 0;
            int b = 0;
            int answer = Integer.MAX_VALUE;
    
            for(int i = 0; i < A.length; i++) {
                b += A[i];
            }
    
            for(int i = 0; i < A.length - 1; i++) {
                a += A[i];
                b -= A[i];
    
                int temp = Math.abs(a - b);
    
                answer = Math.min(answer, temp);
            }
    
            return answer;
        }
    }
}
