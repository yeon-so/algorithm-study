package codility;

import java.util.*;

class Solution {

    // HashMap 사용 - O(N)
    public int solution1(int[] A) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i],0) + 1);
        }

        for(Integer key : map.keySet()) {
            if(map.get(key) % 2 == 1) {
                return key;
            }
        }

        return 0;
    }

    // XOR 사용 - O(N) 이지만 공간이 O(1)
    // XOR - n ^ n = 0 , 0 ^ n = n
    // XOR은 순서를 바꿔도 결과가 같으므로 1 ^ 2 ^ 2 ^ 1 ^ 3 = 3 이 나온다.
    public int solution2(int[] A) {
        if(A.length == 0)
            return 0;

        int answer = A[0];

        for(int i = 1; i < A.length; i++) {
            answer ^= A[i];
        }

        return answer;
    }
}
