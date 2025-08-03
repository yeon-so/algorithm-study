import java.util.Arrays;

public class 숫자_게임 {
        public int solution(int[] A, int[] B) {
        int answer = 0;
        
        int length = A.length - 1;
        int idx = length;
        
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = length; i >= 0; i--) {
            if(B[idx] > A[i]) {
                idx--;
                answer++;
            }
        }
        
        return answer;
    }
}
