package beakjoon.DP.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam_11066 {
    
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] sum = new int[k+1];
            int[][] dp = new int[k+1][k+1];

            for(int j = 1; j <= k; j++) {
                int temp = Integer.parseInt(st.nextToken());
                sum[j] = sum[j-1] + temp;
            }

            for(int x = 1; x < k; x++) { // 1~x 범위
                for(int y = 1; y <= k-x; y++){ // 파일 합치는 시작 부분
                    dp[y][x+y] = Integer.MAX_VALUE;

                    for(int mid = y; mid < x+y; mid++) { // 두 부분으로 나누는 기준
                        dp[y][x+y] = Math.min(dp[y][x+y], dp[y][mid] + dp[mid+1][x+y] + sum[x+y] - sum[y-1]);
                    }
                }
            }

            System.out.println(dp[1][k]);
        }
            
    }

}
