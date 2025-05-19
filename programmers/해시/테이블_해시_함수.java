package programmers.해시;

import java.util.*;

public class 테이블_해시_함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        // 1. 정렬 (O(nlogn))
        Arrays.sort(data, (a,b) -> {
            // col 번째 컬럼 값 기준 오름차순
            if(a[col - 1] != b[col - 1]) {
                return a[col - 1] - b[col -1];
            } else {
                // col 번째 컬럼 값이 같으면 기본키 기준 내림차순
                return b[0] - a[0];
            }
        });
        
        // 2. 나머지 합 (O(n*m))
        for(int i = row_begin; i <= row_end; i++) {
            int sum = 0;
            for(int j = 0; j < data[i - 1].length; j++) {
                sum += data[i-1][j] % i;
            }
            // 3. XOR (O(n))
            answer ^= sum;
        }
        
        return answer;
    }
}
