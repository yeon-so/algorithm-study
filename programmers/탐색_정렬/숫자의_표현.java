package programmers.탐색_정렬;

public class 숫자의_표현 {

    // 완전 탐색 O(N^2)
    class Solution {
        public int solution(int n) {
            int answer = 0;
            
            for(int i = 1; i <= n; i++) {
                int temp = 0;
                for(int j = i; j <=n; j++) {
                    temp += j;
                    if(temp == n) {
                        answer++;
                        break;
                    }
                    if(temp > n) {
                        break;
                    }
                }
            }
            return answer;
        }
    }

}
