public class CountDiv {

    // A = 6, B = 11, K = 2
    // B/K 로 나온 값 (2,4,6,8,10) - A/K(6,8,10)로 나온 값 = 2
    // 만일 A%K 면 A값도 포함되어야 하므로 +1 = 3
    class Solution {
        public int solution(int A, int B, int K) {
            int count = 0;
    
            count = B / K - A / K;
    
            if(A % K == 0) {
                count++;
            }
    
            return count;
        }
    }
    
}
