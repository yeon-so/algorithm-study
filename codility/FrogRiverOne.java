package codility;

import java.util.*;

class Solution {
    public int solution(int X, int[] A) {
        Set<Integer> positions = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            positions.add(A[i]);
            if (positions.size() == X) {
                return i;
            }
        }

        return -1;
    }
}