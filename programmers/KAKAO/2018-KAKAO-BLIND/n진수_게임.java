package programmers.2018-KAKAO-BLIND;

public class n진수_게임 {

    // Integer.toString(num, 진수) 사용 
    public String solution1(int n, int t, int m, int p) {
        
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

        // 직접 진법 변환 사용 
        public String solution2(int n, int t, int m, int p) {
        
            StringBuilder sb1 = new StringBuilder();
            int num = 0;
            
            while(sb1.length() < t * m){
                sb1.append(numberConversion(num++, n));
            }
            
            StringBuilder sb2 = new StringBuilder();
            
            for(int i = 0; i < t; i++) {
                sb2.append(sb1.charAt(i * m + (p - 1)));
            }
            
            String answer = sb2.toString().toUpperCase();
            return answer;
        }

        public String numberConversion(int num, int n){
            if(num == 0) {
                return "0";
            }

            StringBuilder sb = new StringBuilder();

            while(num < 0) {
                int temp = num % n;
                if(temp < 10) {
                    sb.append(temp);
                } else {
                    sb.append((char)(temp - 10 + 'A'));
                }
                num /= n;
            }

            return sb.reverse().toString();
        }
}
