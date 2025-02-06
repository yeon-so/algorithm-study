package beakjoon.정렬.JAVA;

import java.util.*;
import java.io.*;

/*
 * 이분 탐색 사용 
 */

public class Exam_10816_2 {

    static int N;
    static int M;
    static int[] list;

    // 처음 수가 시작되는 인덱스
    static int lowerIdx(int data) {
        int left = 0;
        int right = N;

        while(left < right) {
            int mid = (left + right) / 2;
            if(list[mid] < data) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // 마지막으로 수가 등장하는 인덱스 + 1
    static int upperIdx(int data) {
        int left = 0;
        int right = N;

        while(left < right) {
            int mid = (left + right) / 2;
            if(list[mid] <= data) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            list[i] = temp;
        }

        // 오름차순 정렬
        Arrays.sort(list);

        M = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            int temp = Integer.parseInt(st.nextToken());
            int lower = lowerIdx(temp);
            int upper = upperIdx(temp);
            sb.append(upper - lower).append(" ");
        }

        System.out.println(sb.toString());
    }
}
