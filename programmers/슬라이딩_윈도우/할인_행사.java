package programmers.슬라이딩_윈도우;

import java.util.HashMap;
import java.util.Map;

public class 할인_행사 {

    public int solution1(String[] want, int[] number, String[] discount) {
        
        Map<String, Integer> wmap = new HashMap<>();
        int answer = 0;
        
        for(int i = 0; i < want.length; i++) {
            wmap.put(want[i], number[i]);
        }
        
        for(int i = 0; i < discount.length - 9; i++) {
            Map<String, Integer> dmap = new HashMap<>();
            
            for(int j = i; j < i + 10; j++) {
                dmap.put(discount[j], dmap.getOrDefault(discount[j], 0) + 1);
            }
            
            boolean matched = true;
            for (String e : wmap.keySet()) {
                if (dmap.getOrDefault(e, 0) != wmap.get(e)) {
                    matched = false;
                    break;
                }
            }

            if (matched) answer++;
        }
        
        return answer;
    }
}
