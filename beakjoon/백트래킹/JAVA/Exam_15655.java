package beakjoon.백트래킹.JAVA;

import java.io.*;
import java.util.*;

public class Exam_15655 {
    static int N;
    static int M;
    static int[] nums = new int[10];
    static int[] result = new int[10];
    static boolean[] isUsed = new boolean[10];

    static void func(int st, int cur){
        if(cur == M) {
            for(int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = st; i < N; i++){
            if(!isUsed[i]){
                result[cur] = nums[i];
                isUsed[i] = true;
                func(i, cur+1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[] temp = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(nums, 0, N);

        func(0,0);
    }
}

