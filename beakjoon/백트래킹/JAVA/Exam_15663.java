package beakjoon.백트래킹.JAVA;

import java.io.*;
import java.util.*;

public class Exam_15663 {
    static int N;
    static int M;
    static int[] nums;
    static int[] result;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();
    static Set<String> set = new HashSet<>();

    static void func(int cur) {
        if(cur == M) {
            for(int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int tmp = 0;
        for(int i = 0; i < N; i++) {
            if(!isUsed[i] && tmp != nums[i]){
                isUsed[i] = true;
                result[cur] = nums[i];
                tmp = nums[i];
                func(cur + 1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        result = new int[N];
        isUsed = new boolean[N];

        String[] strs = br.readLine().split(" ");

        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        
        Arrays.sort(nums);

        func(0);

        System.out.println(sb);
    }
}
