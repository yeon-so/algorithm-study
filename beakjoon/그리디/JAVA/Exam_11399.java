package beakjoon.그리디.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간이 짧은 사람부터 처리하면 대기 시간이 최소화 된다. - 그리디
// O(NlogN)
public class Exam_11399 {
    public static void main(String[] args) throws IOException {
        int n;
        int[] arr;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } 

        Arrays.sort(arr);

        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans += arr[n-i-1]*(i+1);
        }

        System.out.println(ans);
    }   
}
