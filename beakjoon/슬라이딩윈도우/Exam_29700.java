package beakjoon.슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam_29700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = 0;

        for(int i = 0; i < N; i++) {

            // 가로줄
            String[] row = br.readLine().split("");

            // 예매 가능한 빈 카운트 세기
            int count = 0;

            for(int j = 0; j <= M; j++) {

                // 끝 처리 (끝에 닿았다면 무조건 1 처리하여 초기화한다.)
                int e = (j == M) ? 1 : Integer.parseInt(row[j]);

                // 현재 좌석이 예매 가능한 좌석이라면 window++
                if(e == 0) {
                    count++;
                } else { // 예매 불가능한 좌석이라면

                    // 현재까지 체크한 카운트 값이 동아리원 수보다 크거나 같을 때 예매 경우의 수를 구한다.
                    if(count >= K) {
                        result += count - K + 1; 
                    }

                    // 슬라이딩 윈도우 초기화
                    count = 0;
                }

            }
        }

        System.out.println(result);

    }
}
