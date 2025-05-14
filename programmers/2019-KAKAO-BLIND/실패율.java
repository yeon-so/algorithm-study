package programmers.2019-KAKAO-BLIND;
import java.util.*;

public class 실패율 {

    public class Failure {
        int stage;
        double failureRate;

        Failure(int stage, double failureRate) {
            this.stage = stage;
            this.failureRate = failureRate;
        }
    }
    
    // O(NlogN)
    public int[] solution(int N, int[] stages) {
        
        // 스테이지에 도달하지 못한 수
        Map<Integer, Integer> map = new HashMap<>();
        // 각 스테이지 별 실패율
        List<Failure> failureList = new ArrayList<>();
        int[] answer = new int[N];
        
        for(int a : stages) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        int cur = 0;
        for(int i = 1; i <= N; i++) {
            // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수
            int failed  = map.getOrDefault(i, 0);
            // 스테이지에 도달한 플레이어 수
            int successed = stages.length - cur;

            // successed가 0일 경우 NaN이 발생하여 정렬시 문제가 될 수 있어 삼항 연산자 사용
            double curFailure = successed == 0 ? 0 : (double)failed / successed;
            failureList.add(new Failure(i, curFailure));
            cur += failed;
        }

        // 정렬
        failureList.sort((a,b) -> {
            if(Double.compare(b.failureRate, a.failureRate) != 0) {
                return Double.compare(b.failureRate, a.failureRate); // 실패율 내림차순
            } else {
                return Integer.compare(a.stage, b.stage); // 실패율이 같을 경우 스태이지 기준 오름차순
            }
        });
        
        for(int i = 0; i < N; i++) {
            answer[i] = failureList.get(i).stage;
        }    
            
        return answer;
    }
}
