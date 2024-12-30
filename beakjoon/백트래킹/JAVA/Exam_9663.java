package beakjoon.백트래킹.JAVA;

import java.util.*;
import java.io.*;
import java.lang.Math;

public class Exam_9663 {
    static int n;
    static int[] a;
    static int count = 0;

    static void func(int cur) {
        if(cur == n) {
            count++;
            return;
        }

        for(int i = 0; i < n; i++) {
            a[cur] = i;
            if(condition(cur)){
                func(cur+1);
            }
        }
    }

    // 여기서 cur은 행을 의미
    static boolean condition(int cur) {
        for(int i = 0; i < cur; i++){
            // a[cur] == a[i] : 같은 열에 있다면
            // Math.abs(cur - i) == Math.abs(a[cur] - a[i]) : 같은 대각선 상에 있다면
            // 같은 대각선의 경우 즉 cur이 (3.1) 일때 i가 (2.2). (4.0) |행-행| == |열-열| 
            if(a[cur] == a[i] || Math.abs(cur - i) == Math.abs(a[cur] - a[i])){
                return false;
            } 
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];

        func(0);
        System.out.println(count);
    }
}
