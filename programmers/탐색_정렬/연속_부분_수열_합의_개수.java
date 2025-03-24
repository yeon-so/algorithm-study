import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 연속_부분_수열_합의_개수 {

    class Solution1 {
        public int solution(int[] elements) {
            int n = elements.length;
            // 배열의 끝을 넘어가는 부분을 탐색할 수 있도록 배열 2배로
            int[] new_elements = new int[n * 2];
            
            for(int i = 0; i < n * 2; i++){
                new_elements[i] = elements[i % n];
            }
            
            // 반복을 제거하기 위해 연속 부분 수열의 합은 set으로 저장
            Set<Integer> sumSet = new HashSet<>();
            
            // 연속 부분 수열합 
            for(int i = 1; i <= n; i++) { // 부분 수열 길이 (1~n)
                int sum = 0;
                
                // 윈도우 값
                for(int j = 0; j < i; j++) {
                    sum += new_elements[j];
                }
                sumSet.add(sum);
                
                // 슬라이딩 윈도우
                for(int k = 1; k < n; k++) {
                    sum = sum - new_elements[k - 1] + new_elements[k + i - 1];
                    sumSet.add(sum);
                }
            }
            
            
            return sumSet.size();
        }
    }

    class Solution2 {
        public int solution(int[] elements) {
            int n = elements.length;
            int sum = 0;
            Map<Integer, Integer> map = new HashMap<>();
            
            for(int i = 0; i< n; i++){
                sum += elements[i];
                map.put(sum, map.getOrDefault(sum, 0));
                int temp = sum;
                
                for(int j = 1; j < n; j++) {
                    temp = temp - elements[j - 1] + elements[(i + j) % n];
                    map.put(temp, map.getOrDefault(temp, 0));
                }
            }
            return map.size();
        }
    }

    
}
