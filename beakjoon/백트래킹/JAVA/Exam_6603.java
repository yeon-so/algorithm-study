package beakjoon.백트래킹.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1 ~ 49 개 중 6개
// k개의 수를 골라 집합 S를 만든다.

public class Exam_6603 {
    static final int NUM = 6;
    static int k;
    static int[] s;
    static int[] result = new int[NUM];
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();

    static void func(int st, int cur) {
        if(cur == NUM) {
            for(int i = 0; i < NUM; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = st; i < k; i++) {
            if(!isUsed[i]){
                isUsed[i] = true;
                result[cur] = s[i];
                func(i, cur+1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String[] temp = br.readLine().split(" ");

            k = Integer.parseInt(temp[0]);
            s = new int[k];
            isUsed = new boolean[k];
            
            if(k == 0) {
                break;
            }

            for(int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(temp[i+1]);
            }

            func(0,0);
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}
