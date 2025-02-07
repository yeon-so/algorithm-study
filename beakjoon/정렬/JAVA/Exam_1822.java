package beakjoon.정렬.JAVA;

import java.util.*;
import java.io.*;

public class Exam_1822 {

    static int nA;
    static int nB;

    static int[] a;
    static int[] b;

    static boolean func(int target) {
        int left = 0;
        int right = b.length;

        while(left < right) {
            int mid = (left + right) / 2;
            if(b[mid] == target) return true;
            if(b[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nA = Integer.parseInt(st.nextToken());
        int nB = Integer.parseInt(st.nextToken());

        a = new int[nA];
        b = new int[nB];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < nA; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < nB; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nA; i++) {
            if(!func(a[i])) {
                cnt += 1;
                sb.append(a[i]).append(" ");
            }
        }
        
        System.out.println(cnt);
        if(cnt > 0) System.out.println(sb.toString());
    }
}

