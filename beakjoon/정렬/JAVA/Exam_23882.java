package beakjoon.정렬.JAVA;

import java.io.*;
import java.util.*;

public class Exam_23882 {

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) throws IOException{
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
        for(int last = N - 1; last >= 1; last--) {
            int maxIndex = last;
            for(int j = last - 1; j >= 0; j--) {
                if(A[j] > A[maxIndex]) {
                    maxIndex = j;
                }
            }

            if(last != maxIndex) {
                swap(A, maxIndex, last);
                count++;
            }

            if(count == K) {
                break;
            }
        }

        if(count < K) {
            System.out.print(-1);
        } else {
            for(int i = 0; i < N; i++) {
                System.out.print(A[i] + " ");
            }
        }
    }

}
