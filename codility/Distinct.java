import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Distinct {

    // Set 사용 - O(NlogN) or O(N)
    public int solution1(int[] A) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }

        return set.size();

    }

    // Sort 사용 - O(NlogN) or O(N)
    public int solution2(int[] A) {

        if(A.length ==0){
            return 0;
        }

        int result = 1;

        Arrays.sort(A);

        for(int i = 1 ; i < A.length; i++) {
            if(A[i] != A[i-1]) {
                result++;
            }
        }

        return result;
        
    }
}
