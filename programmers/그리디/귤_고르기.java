package programmers.그리디;

import java.util.*;

// 그리드 (최소 종류의 귤을 고르는 문제, 가장 많이 나오는 귤부터 고르기 때문에 그리디)
public class 귤_고르기 {
    class Solution1{
        public int solution(int k, int[] tangerine) {
            int answer = 0;
            Map<Integer,Integer> map = new HashMap<>();
            
            for(int i = 0; i < tangerine.length; i++) {
               map.put(tangerine[i], map.getOrDefault(tangerine[i],0) + 1);
            }
            
            List<Integer> list = new ArrayList<>(map.values());
            
            Collections.sort(list);
        
            for(int i = list.size() -1; i >= 0; i--) {
                
                int temp = list.get(i);
                
                k -= temp;
                answer++;
                
                System.out.println(temp);
                
                if(k <= 0) {
                    break;
                }
                
            }
            
            return answer;
        }
    }

    class Solution2 {
        public int solution(int k, int[] tangerine) {
            int answer = 0;
            Map<Integer,Integer> map = new HashMap<>();
            
            for(int i = 0; i < tangerine.length; i++) {
               map.put(tangerine[i], map.getOrDefault(tangerine[i],0) + 1);
            }
            
            List<Integer> list = new ArrayList<>(map.values());
            
            Collections.sort(list);
        
            for(int i = list.size() -1; i >= 0; i--) {
                
                int temp = list.get(i);
                
                k -= temp;
                answer++;
                
                System.out.println(temp);
                
                if(k <= 0) {
                    break;
                }
                
            }
        
            return answer;
        }
    }
}
