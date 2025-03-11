package programmers.그리디;

import java.util.Arrays;

// 그리드 (가장 무거운 사람과 가장 가벼운 사람을 같이 태우는 것이 최적)
// 투포인트 (가장 가벼운 사람과 가장 무거운 사람을 짝지어 태움)
public class 구명보트 {
    class Solution {
        public int solution(int[] people, int limit) {
            
            int answer = 0;
            
            // 오름차순으로 정렬 O(NlogN)
            Arrays.sort(people);
            
            int left = 0;
            int right = people.length - 1;
            
            while(left <= right) { // O(N)
                // 가장 가벼운 사람을 함께 태울 수 있을 경우 
                if(people[left] + people[right] <= limit) {
                    // 가벼운 사람도 함께 태움
                    left++;
                }
                // 가장 무거운 사람은 무조건 태움
                right--;
                // 구명보트 갯수 추가
                answer++;
            }
            
            return answer;
        }
    }
}
