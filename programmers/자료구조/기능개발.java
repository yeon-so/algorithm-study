package programmers.자료구조;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {

    // O(n)
    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        // 날짜 계산
        for(int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            
            if(remain % speeds[i] == 0) {
                queue.offer(remain / speeds[i]);
            } else {
                queue.offer(remain / speeds[i] + 1);
            }
        }
        
        // 몇 개의 기능이 배포되는지
        while(!queue.isEmpty()) {
            int current = queue.poll();
            int count = 1;
            
            while(!queue.isEmpty() && queue.peek() <= current) {
                count++;
                queue.poll();
            }
            
            answer.add(count);
        }      
        
        return answer.stream().mapToInt(i -> i).toArray();
        
    }
}
