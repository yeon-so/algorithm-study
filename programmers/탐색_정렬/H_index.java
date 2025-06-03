package programmers.탐색_정렬;

import java.util.*;

public class H_index {

    // h번 이상 인용된 논문이 h편 이상 있을 때 가능한 최대 h 값
    public int solution(int[] citations) {
        
        Arrays.sort(citations);
        
        for(int i = 0; i < citations.length; i++) {
            
            // 인용된 논문의 수
            int h = citations.length - i;
            
            // 인용된 논문 갯수가 h편 이상인지
            if(citations[i] >= h) {
                return h;
            }
        }
        
        return 0;
    }

}
  