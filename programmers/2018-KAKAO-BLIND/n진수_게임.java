package programmers.2018-KAKAO-BLIND;

public class n진수_게임 {

    // Integer.toString(num, 진수) 사용 
    public String solution(int n, int t, int m, int p) {
        
        StringBuilder sb1 = new StringBuilder();
        int num = 0;
        
        while(sb1.length() < t * m){
            sb1.append(Integer.toString(num++, n));
        }
        
        StringBuilder sb2 = new StringBuilder();
        
        for(int i = 0; i < t; i++) {
            sb2.append(sb1.charAt(i * m + (p - 1)));
        }
        
        String answer = sb2.toString().toUpperCase();
        return answer;
    }
}
