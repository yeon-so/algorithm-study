package beakjoon.정렬.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam_23881 {

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int a = 0;
        int b = 0;
        for(int i = N - 1 ; i >= 1; i--) {
            int maxIndex = i;
            for(int j = i - 1; j >= 0; j--) {
                if(A[j] > A[maxIndex]) {
                    maxIndex = j;
                }
            }

            if(i != maxIndex) {
                swap(A, maxIndex, i);
                count++;
            }

            if(count == K) {
                a = A[maxIndex];
                b = A[i];
                break;
            }
        }

        if(count < K) {
            System.out.print(-1);
        } else {
            System.out.print(a + " " + b);
        }
    }
}
