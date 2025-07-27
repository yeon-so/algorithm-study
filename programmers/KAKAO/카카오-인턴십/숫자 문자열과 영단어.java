import java.util.*;

public class 숫자 문자열과 영단어 {
    
    static boolean[] checkArr;
    static StringBuilder sb = new StringBuilder();
    
    static public void check(int start, int index, int num) {
        for(int i = start; i < start + index; i++) {
            checkArr[i] = true;
        }
        sb.append(num);
    } 
    
    public int solution(String s) {
        int answer = 0;
        checkArr = new boolean[s.length()];
        
        for(int i = 0; i < s.length(); i++) {
            
            if(checkArr[i]) {
                continue;
            }
            
            char ch = s.charAt(i);
            
            if(ch >= 'a' && ch <= 'z') {
                if(ch == 'z') {
                    check(i, 4, 0);
                } else if(ch == 'o') {
                     check(i, 3, 1);
                } else if(ch == 't') {
                    if(s.charAt(i+1) == 'w'){
                        check(i, 3, 2);
                    } else {
                        check(i, 5, 3);
                    }
                } else if(ch == 'f') {
                    if(s.charAt(i+1) == 'o'){
                        check(i, 4, 4);
                    } else {
                        check(i, 4, 5);
                    }                  
                } else if(ch == 's') {
                    if(s.charAt(i+1) == 'i'){
                        check(i, 3, 6);
                    } else {
                        check(i, 5, 7);
                    }   
                } else if(ch == 'e') {
                    check(i, 5, 8);
                } else {
                    check(i, 4, 9);
                }
            } else {
                sb.append(ch);
            }   
        }
        
        answer = Integer.parseInt(sb.toString());
        
        return answer;
    }

}
