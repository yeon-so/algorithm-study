package beakjoon.백트래킹.JAVA;

import java.io.*;
import java.util.*;

public class Exam_15654 {

    static int N;
    static int M;
    static int[] a = new int[10];
    static int[] r = new int[10];
    static boolean[] isUesd = new boolean[10];

    static void func(int cur) {
        if(cur == M) {
            for(int i = 0; i < M; i++) {
                System.out.print(r[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i< N; i++) {
            if(!isUesd[i]){
                isUesd[i] = true;
                r[cur] = a[i];
                func(cur + 1);
                isUesd[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[] temp = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            a[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(a, 0, N);

        func(0);
    }
}
