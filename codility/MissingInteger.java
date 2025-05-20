import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingInteger {

    // 1. 정렬 사용 - O(NlogN)
    public int solution1(int[] A) {
            int min = 1;

            // O(NlogN)
            Arrays.sort(A);

            for(int i = 0; i < A.length; i++) {
                if(A[i] == min) {
                    min++;
                    continue;
                }

                if(A[i] > min) {
                    break;
                }
            }

            return min;
        }

    // 2. Set 사용 - O(N), worst - O(N * log N) 
    public int solution2(int[] A) {
            int min = 1;

            if(A.length == 0) {
                return 1;
            }

            Set<Integer> set = new HashSet<>();

            for(int i = 0; i < A.length; i++) {
                set.add(A[i]);
            }

            for(int i = 1; i <= A.length; i++) {
                if(!set.contains(i)) {
                    return i;
                }

            }

            return A.length + 1;
    }

}
