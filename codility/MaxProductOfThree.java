import java.util.Arrays;

public class MaxProductOfThree {
        public int solution(int[] A) {
        
        // 1. 양수 * 양수 * 양수
        // 2. 음수 * 음수 * 양수
        int L = A.length;

        Arrays.sort(A);

        int ans1 = A[L - 3] * A[L - 2] * A[L - 1]; 
        int ans2 = A[0] * A[1] * A[L - 1]; 

        return Math.max(ans1, ans2);

    }
}
