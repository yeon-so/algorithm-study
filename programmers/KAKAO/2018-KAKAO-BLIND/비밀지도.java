package programmers.2018-KAKAO-BLIND;

public class 비밀지도 {
    // StringBuilder 사용 - O(n^2)
    public String[] solution1(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++) {
        
            int temp = arr1[i] | arr2[i];
            StringBuilder sb = new StringBuilder();
            
            for(int j = 0; j < n; j++) {
                
                if(temp%2 == 1) {
                    sb.insert(0,"#");
                } else {
                    sb.insert(0," ");
                }
                
                temp /= 2;
                
            }
            
            answer[i] = sb.toString();
            
        }
        
        return answer;
    }

    // toBinaryString 사용 - O(n^2)
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++) {
            String temp = Integer.toBinaryString(arr1[i] | arr2[i]);
            
            if(temp.length() < n) {
                String zero = "";
                for(int j = 0; j < n - temp.length(); j++){
                    zero += "0";
                }
                temp = zero + temp;
            }
            
            temp = temp.replaceAll("1","#");
            temp = temp.replaceAll("0"," ");
            answer[i] = temp;
 
        }

        
        return answer;
    }
}
