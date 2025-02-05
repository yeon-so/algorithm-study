package beakjoon.정렬.JAVA;

import java.util.*;
import java.io.*;

public class Exam_1920 {
    // 선형으로 작업 시 O(NM) = 10^10 초과 -> X
    // 이분탐색 O(NlogN) + O(MlogN) = O((N+M)logN) -> O

    static int[] arr;

    static boolean func(int m){
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == m) return true;
            if(arr[mid] < m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if(!func(temp)) {
                sb.append("0\n");
            } else {
                sb.append("1\n"); 
            }
        }

        System.out.println(sb);

        br.close();

    }
}
