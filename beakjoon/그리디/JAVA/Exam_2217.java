package beakjoon.그리디.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Exam_2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] a = new Integer[n];

        for(int i = 0; i < n; i++) { // O(N)
            a[i] = Integer.parseInt(br.readLine());
        }

        // 내림차순으로 정렬 O(NlogN)
        Arrays.sort(a, Collections.reverseOrder());

        int ans = 0;

        for(int i = 0; i < n; i++) { // O(N)
            // a[i]*(i+1) : i개 중에 최대 중량이 가장 낮은 것을 i+1개 만큼 곱한다.
            // 그중 최댓값을 고른다.
            ans = Math.max(ans, a[i]*(i+1));
        }

        System.out.println(ans);
    }
}
