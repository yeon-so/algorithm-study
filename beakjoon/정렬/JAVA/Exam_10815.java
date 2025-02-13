package beakjoon.정렬.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exam_10815 {
    static int n;
    static int[] arr;
    static int m;

    static boolean func(int temp) {
        int left = 0;
        int right = n - 1; // n으로 할 경우 인덱스 값을 넘기니 주의

        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == temp) return true;
            if(arr[mid] < temp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if(func(temp)) {
                sb.append("1").append(" ");
            } else {
                sb.append("0").append(" ");
            }
        }
        
        System.out.println(sb.toString());
    }
}
