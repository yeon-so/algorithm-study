package beakjoon.정렬.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exam_2805 {
    static int n;
    static int m;
    static int[] arr;

    static int func(int target) {
        int left = 0;
        int right = arr[n-1];
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;
            for(int i = 0; i < n; i++) {
                if(mid < arr[i]){
                    sum += arr[i] - mid; 
                }
            }

            if(sum >= target) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }   
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int result = func(m);
        System.out.println(result);
    }
}
