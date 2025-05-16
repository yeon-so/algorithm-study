package programmers.그리디;

import java.util.Arrays;
import java.util.HashSet;

public class 체육복 {

     // O(nlogn)
     public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        // 13, 14 테스트 케이스 실패 처리
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        HashSet<Integer> re = new HashSet<>();
        
        for(int e : reserve) {
            re.add(e);
        }
        
        // 본인이 도난 당했으나 여벌이 있는 경우
        for(int i = 0; i < lost.length; i++) {
            if(re.contains(lost[i])) {
                answer++;
                re.remove(lost[i]);
                lost[i] = -1;
            }
        }
        
        // 체육복을 빌려준 경우
        for(int i = 0; i < lost.length; i++) {
            
            if (lost[i] == -1) continue;
            
            if(re.contains(lost[i] - 1)) {
                answer++;
                re.remove(lost[i] - 1);
            } else if(re.contains(lost[i] + 1)) {
                answer++;
                re.remove(lost[i] + 1);
            }
        }
        
        return answer;
    }
}
