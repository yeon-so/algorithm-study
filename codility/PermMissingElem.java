package codility;

public class PermMissingElem {
    // 카우팅 배열 이용 - O(N)
    class Solution1 {
        public int solution(int[] A) {

            int[] result = new int[A.length + 1];
    
            for(int i = 0; i < A.length; i++) {
                result[A[i] -1]++;
            }
    
            for(int i = 0; i < result.length; i++) {
                if(result[i] == 0) {
                    return i + 1;
                }
            }
    
            return -1;
        }
    }

    // 수학 공식 사용 - O(N), 추가 배열 공간을 안씀
    class Solution2 {
        public int solution(int[] A) {
            int N = A.length + 1;
            long result = (N + 1) * N / 2; // 가우스 공식 (1부터 N까지의 합)

            for(int i = 0; i < A.length; i++) { // 전체 합에서 배열에 있는 숫자를 뺀다.
                result -= A[i];
            }

            return (int) result;

        }
    }
}
