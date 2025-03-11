package programmers.그리디;

import java.util.*;

public class 점프와_순간이동 {
    // 순간이동이 가능한 경우 항상 순간이동을 선택하는 것이 유리하므로 그리디
    // N이 짝수면 /2, 홀수면 -1 (점프) 과정이 반복 - DP (단 0부터 시작하면 10억개 이상이 발생하여 O(n)초과)
    // 따라서 N부터 역으로 구해주면 쉽게 풀 수 있다. 

    // 틀린 풀이
    // public class Solution {
    //     public int solution(int n) {
    //         int ans = 0;
            
    //         int[] a = new int[n+1];
            
    //         a[1] = 1;
    //         a[2] = 1;
            
    //         for(int i = 3; i <= n; i++) {
    //             a[i] = a[i/2] + (i%2);
    //         }
            
    //         ans = a[n];
            
    //         return ans;
    //     }
    // }

    public class Solution1 { // O(N)
        public int solution(int n) {
            int ans = 0;
             
            // Integer.bitCount(n); 으로도 해결 가능
            while(n > 0) {
                if(n%2 == 1){
                    ans++;
                }
                
                n = n/2;
            }
            return ans;
        }
    }

    // 분할정복(재귀) O(logN)
    public class Solution2 {
        public int func(int n) {
            // 종료 조건 (Base Case)
            if(n == 1) { return 1; }
            // 재귀 호출
            else { return (func(n/2) + (n%2)); }
        }
        
        public int solution(int n) {
            return func(n);
        }
    }
}
