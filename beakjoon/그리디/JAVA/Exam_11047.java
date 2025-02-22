package beakjoon.그리디.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(sb.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(sb.readLine());
            int temp = Integer.parseInt(st.nextToken());
            a[i] = temp;
        }

        int count = 0;
        for(int i = n - 1; i >= 0; i--) {
            // 현재 동전으로 사용할 수 있는 갯수 추가
            count += k / a[i];

            // 남은 금액 업데이트
            k %= a[i];
        }

        System.out.println(count);
    }
}
