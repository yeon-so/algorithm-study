package programmers.자료구조;

import java.util.Deque;
import java.util.LinkedList;

public class 짝지어_제거하기 {
    class Solution
    {
        public int solution(String s)
        {
            Deque<Character> stack = new LinkedList<Character>();
            
            for(int i = 0 ; i < s.length(); i++) {       
                char temp = s.charAt(i);
                
                // 스택이 비어있다면 삽입
                if(stack.isEmpty()){
                    stack.push(temp);
                // 비어있지 않다면    
                } else {
                    // 스택 top 확인 후 같은 문자열일 시 현재 스택에서 top값 제거
                    if(stack.peek() == temp){
                        stack.pop();
                    // 아니라면 짝지어 있는 것이 아니므로 새로운 값 삽입
                    } else {
                        stack.push(temp);
                    }
                }
            }
            
            int answer = stack.isEmpty() ? 1 : 0;
            System.out.println(answer);

            return answer;
        }
    }
}
