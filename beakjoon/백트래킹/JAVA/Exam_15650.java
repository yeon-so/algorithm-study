package beakjoon.백트래킹.JAVA;

import java.util.*;
import java.io.*;

public class Exam_15650 {

    static int N;
    static int M;
    static int[] a = new int[10];
    static boolean[] isUsed = new boolean[10];

    static void func(int cur) {
        if(cur == M){
            for(int i = 0; i < M; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            return;
        }

        int st = 1;
        if(cur != 0) st = a[cur-1] +1;
        for(int i = st; i <= N; i++) {
            if(!isUsed[i]){
                a[cur] = i;
                isUsed[i] = true;
                func(cur+1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        func(0);
    }
}
