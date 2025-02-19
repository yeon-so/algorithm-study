package programmers.자료구조;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12909
public class 올바른_괄호 {
    class Solution { // O(N)
        boolean solution(String s) {
            boolean answer = true;
            Queue<Character> q = new LinkedList();
    
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                
                // ')'가 '(' 없이 나타나면 무조건 false
                if(q.isEmpty() && c == ')') {
                    answer = false;
                    break;
                }
                
                // '(' 일 경우 queue에 삽입
                if(c == '(') {
                    q.offer('(');
                } 
                
                // '(' 일 경우 queue에서 제거
                if(c == ')'){
                    q.poll();
                }
            }
            
            // 만일 '('가 남아있다면 false
            if(!q.isEmpty()) {
                answer = false;
            }
    
            return answer;
        }
    }    
}
