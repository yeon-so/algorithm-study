package beakjoon.정렬.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 인덱스를 찾을 때는 min = 0, max = N으로 해도 제대로 탐색이 가능하나
 * 최댓값을 찾을 때는 mid = 1(자연수니 0은 제외), max = N + 1(max값이 max를 넘는 경우를 고려)로 해야한다.
 * 예시 : 5 6 / 6 6 6 6 6
 */
public class Exam_1654 {
    static int k;
    static int n;
    static long[] arr;

    // n개로 자른 랜선의 최대 길이 + 1
    static long func() {

        // 랜선의 최솟값 
        long left = 1;
        // 랜선의 최댓값
        long right = arr[k-1] + 1;

        while (left < right) {
            long mid = (left + right) / 2;
            long count = 0;

            // mid 길이로 잘라 몇 개가 나오는 지 확인
            for(int i = 0; i < arr.length; i++) {
                count += arr[i] / mid;
            }

            // upper bound 사용
            // count가 n 이상이면 더 긴 길이도 가능하므로 left = mid + 1
            // count가 n 미만이면 랜선을 더 잘게 잘라야 하므로 right = mid
            if(n <= count) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new long[k];

        for(int i = 0; i < k; i++) {
            long temp = Integer.parseInt(br.readLine());
            arr[i] = temp;
        }
        
        // 이분 탐색을 위해 랜선 길이를 오름차순 정렬
        Arrays.sort(arr);

        long result = func();

        System.out.println(result - 1);
    }
}
