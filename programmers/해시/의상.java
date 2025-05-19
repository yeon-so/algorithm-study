package programmers.해시;

import java.util.HashMap;
import java.util.Map;

public class 의상 {

    // O(n)
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        // 의상 Map에 삽입
        for(int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        // 의상 경우의 수 구하기
        for(String key: map.keySet()) {
            answer *= map.get(key) + 1;
        }
        
        // 아무것도 입지 않은 경우 제거
        answer -= 1;
        
        return answer;
    }
}
