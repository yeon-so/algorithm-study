package beakjoon.백트래킹.JAVA;

import java.io.*;
import java.util.*;

public class Exam_15657 {
    static int N;
    static int M;
    static int[] nums;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    static void func(int st, int cur) {
        if(cur == M) {
            for(int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = st; i < N; i++) {
            result[cur] = nums[i];
            func(i, cur+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        result = new int[N];

        String[] tStrings = br.readLine().split(" ");
        
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(tStrings[i]);
        }

        Arrays.sort(nums);

        func(0, 0);

        System.out.println(sb);
    }
}
