package programmers.DP;

public class 멀리_뛰기 {

// d[1] = 1 
// d[2] = 2 
// d[3] = 3 111 12 21
// d[4] = 5 1111 121 112 211 22
// d[5] = 11111 1211 1121 2111 1112 122 212 221 
// d[n] = d[n-2] + d[n-1]

    class Solution {
        public long solution(int n) {      
            int[] a = new int[2001];
            
            a[1] = 1;
            a[2] = 2;
            
            for(int i = 3 ; i <= n; i++) {
                a[i] = (a[i-1] + a[i-2]) % 1234567;
            }
            
            return a[n];
        }
    }
}
