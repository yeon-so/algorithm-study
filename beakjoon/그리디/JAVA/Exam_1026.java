package beakjoon.그리디.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 문제에서는 b는 재배열하면 안된다고 나와있지만 결구 s값만 구하면 되므로 둘 다 정렬해서 곱해주면 된다.
// S = A[0] × B[0] + ... + A[N-1] × B[N-1]
public class Exam_1026 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer a[] = new Integer[n];
        Integer b[] = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        int s = 0;
        for(int i = 0; i < n; i++) {
            s += a[i] * b[i];
        }

        System.out.println(s);

    }
}
