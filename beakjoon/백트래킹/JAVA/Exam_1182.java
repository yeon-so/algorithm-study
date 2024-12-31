package beakjoon.백트래킹.JAVA;

import java.util.*;
import java.io.*;

public class Exam_1182 {

    static int n;
    static int s;
    static int[] a;
    static int cnt = 0;

    static void func(int cur, int total) {
        if(cur == n) {
            if(total == s) cnt++;
            return;
        }

        // 현재값을 합계에 포함X
        func(cur+1, total);

        // 현재값을 합계에 포함
        func(cur+1, total + a[cur]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        a = new int[n];
        String[] temp = br.readLine().split(" ");
        
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(temp[i]);
        }

        func(0,0);

        // 공집합 제외
        if(s == 0 && cnt > 0) {
            cnt = cnt -1;
        }

        System.out.println(cnt);
    }
}
