package beakjoon.그리디.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exam_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][2];
        int count = 0;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            a[i][0] = start;
            a[i][1] = end;
        }

        Arrays.sort(a, (x, y) -> {
            // 끝나는 시간이 같으면 시작 시간이 빠른 순
            if(x[1] == y[1]) {
                return x[0] - y[0];
            }
            // 끝나는 시간이 빠른 순
            return x[1] - y[1];
        });

        // 현재 시간
        int t = 0;
        for(int i = 0; i < n; i++) {
            // 현재 시간이 시작 시간보다 작거나 같을 때만
            if(t <= a[i][0]){
                // 회의수 증감
                count++;
                // 회의가 끝나는 시간을 지정
                t = a[i][1];
            }
        }

        System.out.println(count);

    }
}
