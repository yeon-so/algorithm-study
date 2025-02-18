package programmers.문자열;

public class JadenCase_문자열_만들기 {

    // 내 풀이
    // 공백이 여러 개일 때를 생각하다가 코드가 길어짐.
    class Solution1 {
        public String solution(String s) {
            
            String[] arr = s.split(" ");
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0 ; i < arr.length; i++) {
                String str = arr[i];
                
                // 공백 문자라면
                if(str.length() == 0) {
                    sb.append(" ");
                    continue;
                }
                
                // 단어의 첫 글자가 숫자가 아니라면
                if(str.charAt(0) < '0' || str.charAt(0) > '9') {
                    // 문자의 첫 글자를 대문자로 변경
                    sb.append(Character.toUpperCase(str.charAt(0)));
                // 단어의 첫 글자가 숫자라면
                } else {
                    // 첫 글자는 숫자를 그대로 두기
                    sb.append(str.charAt(0));
                }
                
                // 첫 글자 제외 소문자로 변경
                sb.append(str.substring(1,str.length()).toLowerCase()).append(" ");
            }
            
            // 마지막 단어의 공백문자 제거
            sb.deleteCharAt(sb.length() - 1);
            
            // 마지막 단어 뒤 공백문자 추가
            for(int i = s.length() -1; i >= 0; i--) {
                if(s.charAt(i) == ' ') {
                    sb.append(" ");
                } else {
                    break;
                }
            }
            
            String answer = sb.toString();
            return answer;
        }
    }

    // 다른 사람 풀이
    class Solution2 {
        public String solution(String s) {
                String answer = "";
                String[] sp = s.toLowerCase().split("");
                boolean flag = true;

                for(String ss : sp) {
                    answer += flag ? ss.toUpperCase() : ss;
                    flag = ss.equals(" ") ? true : false;
                }

                return answer;
        }
    }
}
