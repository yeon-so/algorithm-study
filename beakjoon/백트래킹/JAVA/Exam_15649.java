package beakjoon.백트래킹.JAVA;

import java.util.*;
import java.io.*;

public class Exam_15649 {

    static int n;
    static int m;
    // m개 만큼 담을 원소
    static int[] arr = new int[10];
    // 1 ~ n까지 사용했는지 여부
    static boolean[] isUsed = new boolean[10];

    static void func(int k) {
        if(k == m) {
            for(int i = 0; i < k; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        for(int i = 1; i <= n; i++) {
            if(!isUsed[i]){
                arr[k] = i;
                isUsed[i] = true;
                func(k+1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        func(0);
    }
}
