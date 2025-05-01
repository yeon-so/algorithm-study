package codility;

import java.util.HashSet;
import java.util.Set;

public class PermCheck {
    class Solution {
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i=0; i < A.length; i++){
            set.add(A[i]);
        }
        
        for(int i=1; i<= A.length; i++){
            if( !set.contains(i) )
                return 0;
        }

        return 1;       
    }
}
}
