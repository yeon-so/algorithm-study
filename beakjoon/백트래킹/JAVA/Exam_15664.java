package beakjoon.백트래킹.JAVA;

import java.io.*;
import java.util.*;

public class Exam_15664 {

    static int N;
    static int M;
    static int[] nums;
    static int[] result;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();

    static void func(int st, int cur) {
        if(cur == M) {
            for(int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int tmp = 0;
        for(int i = st; i < N; i++) {
            // i번째 숫자를 사용하지 않았으며, 중복된 숫자가 아니라면
            if(!isUsed[i] && nums[i] != tmp) {
                isUsed[i] = true;
                result[cur] = nums[i];
                tmp = nums[i];
                func(i, cur+1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        result = new int[N];
        isUsed = new boolean[N];

        String[] tStrings = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(tStrings[i]);
        }

        Arrays.sort(nums);

        func(0, 0);

        System.out.println(sb);

    }
}
