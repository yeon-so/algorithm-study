package programmers.그리디;

import java.util.*;

public class 큰_수_만들기 {

    // O(N)
    public String solution(String number, int k) {
        Deque<Character> dq = new ArrayDeque<>();
        int cnt = 0;
        
        for(int i = 0; i < number.length(); i++) {
            char cur = number.charAt(i);
            
            while (!dq.isEmpty() && cnt < k && dq.peek() < cur) {
                dq.pop();
                cnt++;
            }
            dq.push(cur);
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c : dq) {
            sb.append(c);
        }

        String answer = sb.reverse().substring(0, number.length() - k);
        return answer;
    }
}
