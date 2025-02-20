package programmers.탐색_정렬;

// 비트 마스트 + 완전 탐색
public class 다음_큰_숫자 {

    // toBinaryString(O(logN)) + 숫자 증감 반복문(O(N)) = O(NlogN)
    class Solution1 {
    
        public int func(String temp) {
            int count = 0;
            for(int i = 0; i < temp.length(); i++) { 
                if(temp.charAt(i) == '1') {
                    count += 1;
                }
            }
            
            return count;
        }
        
        public int solution(int n) {
            int answer = 0;
            String nBinary = Integer.toBinaryString(n); // O(logN)
            int count = func(nBinary);
            
            answer = n + 1;
            while(true) { // O(N)
                String temp = Integer.toBinaryString(answer);
                if(func(temp) == count) {
                    break;
                }
                answer++;
            }
            
            return answer;
        }
    }

    // bitCount + 숫자 증감 반복문(O(N)) = O(NlogN)
    class Solution2 {
        public int solution(int n) {
            int answer = n;
            int count = Integer.bitCount(n);
            while(Integer.bitCount(++answer) != count);
            return answer;
        }
    }
}
