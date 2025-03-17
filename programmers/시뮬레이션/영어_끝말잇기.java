package programmers.시뮬레이션;

import java.util.*;

public class 영어_끝말잇기 {
    class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = {0, 0}; 
            Map<String, Integer> m = new HashMap<>();
            
            for(int i = 0 ; i < words.length; i++) {    
                if(m.containsKey(words[i]) || 
                (i > 0 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0))){
                    int failNumber = (i%n) + 1; 
                    int failTurn = (i/n) + 1; 
                    
                    answer[0] = failNumber;
                    answer[1] = failTurn;
                    break;
                }  
                m.put(words[i],1);   
            }
            

            return answer;
        }
    }
}
