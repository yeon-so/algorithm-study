package programmers.탐색_정렬;

public class N_2_배열_자르기 {
    
    // O(M)
    // 문제에서는 2차원 배열이라고 하지만 2차원 배열로 풀 시 데이터가 커지면 시간 초과
    // 데이터 타입도 주의
    public int[] solution(int n, long left, long right) {
        int leng = (int)(right - left + 1);
        int[] answer = new int[leng];
        
        int index = 0;
        for(long i = left; i <= right; i++) {
            int row = (int)(i / n);
            int col = (int)(i % n);
            
            answer[index++] = Math.max(row,col) + 1;
        }
        
        return answer;
    }
}
