package beakjoon.정렬.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam_16401 {

    static int m;
    static int n;
    static long[] arr;

    static long func(long max) {
        long left = 1;
        long right = max;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for(int i = 0; i < n; i++) {
                count += arr[i] / mid;
            }

            if(m <= count) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new long[n];

        long max = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
            max = Math.max(max, temp);
        }

        long result = func(max);

        System.out.println(result - 1);
    }
}
