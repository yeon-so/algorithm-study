package beakjoon.정렬.JAVA;

import java.util.*;
import java.io.*;

public class Exam_18870 {

    static int n;
    static int[] l1;
    static ArrayList<Integer> l2;

    static int func(int target) {
        int left = 0;
        int right = l2.size();

        while(left < right) {
            int mid = (left + right) / 2;
            if(l2.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        l1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            l1[i] = Integer.parseInt(st.nextToken());
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(l1[i]);
        }

        l2 = new ArrayList<>(set);
        Collections.sort(l2);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int result = func(l1[i]); 
            sb.append(result).append(" ");
        }

        System.out.println(sb.toString());
    }   
}
