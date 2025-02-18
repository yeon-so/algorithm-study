package programmers.문자열;

import java.util.*;

public class 최댓값과_최솟값 {

    // O(NlogN)
    class Solution1 { 
        public String solution(String s) {
            
            String[] arr1 = s.split(" ");
            int leng = arr1.length;
            int[] arr2 = new int[leng];
            
            for(int i = 0; i < leng; i++) {
                arr2[i] = Integer.parseInt(arr1[i]);
            }
            
            Arrays.sort(arr2); // O(NlogN)
            
            String answer = arr2[0] + " " + arr2[leng - 1];
            return answer;
            
        }
    }

    // O(N)
    class Solution2 { 
        public String solution(String s) {
        
            String[] arr = s.split(" ");
            int minValue = Integer.MAX_VALUE;
            int maxValue = Integer.MIN_VALUE;
            
            for(String num : arr) { // O(N)
                int temp = Integer.parseInt(num);
                minValue = Math.min(minValue, temp);
                maxValue = Math.max(maxValue, temp);
            }
            
            String answer = minValue + " " + maxValue;
            return answer;
            
        }
    }
}
