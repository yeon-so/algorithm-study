package programmers.시뮬레이션;

public class 예상_대진표 {

    class Solution
    {
        public int solution(int n, int a, int b)
        {
            int answer = 0;
            
            double tempA = Math.min(a,b);
            double tempB = Math.max(a,b);
            
            while(n != 1) {
                
                answer++;
            
                if(tempA%2 == 1 && tempA+1 == tempB) {
                    break;
                } else {
                    tempA = Math.ceil(tempA / 2);
                    tempB = Math.ceil(tempB / 2);
                }
                
                n /= 2;
                
            }

            return answer;
        }
    }

}
