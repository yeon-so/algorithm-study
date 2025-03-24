package programmers.자료구조;

import java.util.ArrayDeque;
import java.util.Deque;

public class 괄호_회전하기 {
    class Solution {
        public int solution(String s) {
            int answer = 0;
            char[] arr = new char[s.length()];
            
            for(int l = 0; l < s.length(); l++){
                Deque<Character> d = new ArrayDeque<>();

                for(int i = 0; i < s.length(); i++) {
                    arr[i] = s.charAt((i + l) % s.length());
                }
                
                for(int i = 0; i < arr.length; i++) {
                    char temp1 = arr[i];
                    if(d.isEmpty()){
                        d.push(temp1);
                    } else if(temp1 == ']' && d.peek() == '['){
                        d.pop();  
                    } else if(temp1 == ')' && d.peek() == '('){
                        d.pop();  
                    } else if(temp1 == '}' && d.peek() == '{'){
                        d.pop();  
                    } else {
                        d.push(temp1);
                    }  
                }
            
                if(d.isEmpty()){
                    answer++;
                }
            }
            
            return answer;
        }
    }
}
