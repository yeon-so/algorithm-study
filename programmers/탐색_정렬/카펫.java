package programmers.탐색_정렬;

public class 카펫 {
    class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];
            
            // 갈색 격자 개수 = 노랑 격자의 세로 개수 * 2 + 노랑 격자의 가로 개수 * 2 + 4
        
            // 세로줄 i
            for(int i = 1; i <= yellow; i++) {
                if(yellow % i == 0){
                    if(brown == (i * 2) + ((yellow/i) * 2) + 4) {
                        answer[0] = (yellow/i) + 2;
                        answer[1] = i + 2;
                        break;
                    }
                }
            }
             
            return answer;
        }
    }
}
