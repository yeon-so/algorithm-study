package programmers.문자열;

import java.util.*;

// 시간 복잡도 : O(NlogN)
// 문자열 처리 + 시뮬레이션 
public class 이진_변환_반복하기 { 
    class Solution {
        
        public String erase(String str) { // O(N)
            StringBuilder sb = new StringBuilder();
            char[] arr= str.toCharArray();
            
            for(char c : arr) {
                if(c == '1') {
                    sb.append('1');
                }
            }
            
            return sb.toString();
        }
        
        public String binary(int c) { // O(logN)
            int[] arr = new int[1000];
            StringBuilder sb = new StringBuilder();
            
            int i = 0;
            while(c > 0) {
                arr[i] = c%2;
                c = c/2;
                i++;
            } 
            
            for(int j = i - 1; j >= 0; j--){
                sb.append(arr[j]);
            }
            
            return sb.toString();
            
        }
        
        public int[] solution(String s) {
            int[] answer = new int[2];
            
            while(!s.equals("1")) {
                int before = s.length();
                
                // 0 제거
                // s = s.replaceAll("0",""); 로 대체 가능
                s = erase(s);
                
                int after = s.length();
                
                answer[0] += 1; // 이진 변환 횟수 증가
                answer[1] += before - after; // 제거한 0의 갯수 증가
    
                // 2진법으로 표현
                // s = Integer.toBinaryString(after); 로 대체가능
                s = binary(after); 
                
            }
            
            return answer;
        }
    }
}
