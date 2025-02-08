package programmers.해시;

import java.util.*;

/*
 * 폰켓몬 O(N)
 */
class 폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i : nums) {
            set.add(i);
        }
        
        // 선택할 수 있는 포켓몬의 최대 갯수
        int n1 = nums.length/2;
        // 중복을 제거한 포멧몬의 종류 수
        int n2 = set.size();
        
        answer = n1 < n2 ? n1 : n2;
        
        return answer;
    }
}