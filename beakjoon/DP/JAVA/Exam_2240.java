package beakjoon.DP.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dp[t][w] = t 시간동안 w번 이동했을 때 얻을 수 있는 자두의 최대 갯수 (이때 기본 위치는 1번 나무 밑)
// 1초부터 t초까지 시간 순으로 dp 배열 값을 구한다.
// 해당 시간에 이동한 횟수 순으로 dp 배열 값을 구한다.
//      한번도 이동을 하지 않았을 경우 (w==0) 
//          열매가 떨어지는 위치와 현재 위치가 같다면 이전 시간의 같은 이동 횟수의 값 + 1
//          위치가 다르다면 이전 시간의 같은 이동 횟수값 그대로   
//      한번 이상 이동을 했을 경우 (w >= 1) : 짝수번 1번나무아래 / 홀수번 2번나무아래
//          현재 위치와 열매가 떨어진 나무 위치가 같다면 
//              움직이지 않았을 때 이전 시간에 같은 이동 횟수에서 자두를 먹은 값 +1
//              움직였을 때 이전 시간의 이동 횟수를 하나 줄인 값에서 자두 먹은 값 +1
//          현재 위치와 열매가 떨어진 나무 위치가 다르면
//              움직이지 않았을 때 이전 시간에 같은 이동 횟수에서 자두를 먹은 값 그대로
//              움직였을 때 이전 시간의 이동 횟수를 하나 줄인 값에서 자두 먹은 값 +1

public class Exam_2240 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

        int[][] dp = new int[T + 1][W + 1];
        int result = 0;
        int curPos = 1;

        int[] tree = new int[T + 1];
		for (int i = 1; i <= T; i++) {
			tree[i] = Integer.parseInt(br.readLine());
		}

        for(int i = 1; i <= T; i++) {
            int treePos = tree[i];

            for(int j = 0; j <= W; j++) {
                if(j == 0) {
                    curPos = 1;
                    if(treePos == curPos) {
                        dp[i][j] = dp[i-1][j] + 1 ;
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }

                    continue;
                }

                if(j % 2 == 0) {
                    curPos = 1;
                    if(treePos == curPos) {
                        dp[i][j] = Math.max(dp[i-1][j] + 1, dp[i-1][j-1]);
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-1] + 1);
                    }
                } else {
                    curPos = 2;
                    if(treePos == curPos) {
                        dp[i][j] = Math.max(dp[i-1][j] + 1, dp[i-1][j-1]);
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-1] + 1);
                    }
                }

                result = Math.max(result, dp[i][j]);
            }
        }

        System.out.println(result);
    }
    
}
