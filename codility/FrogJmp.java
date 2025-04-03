package codility;

public class FrogJmp {
    class Solution {
        public int solution(int X, int Y, int D) {
    
            int dist = Y - X; 
            int count = dist / D;
    
            if(count * D != dist) { // 나머지가 존재한다면 한번 더 점프
                count++;
            }
    
           return count;
        }
    }
}
