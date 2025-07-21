package beakjoon.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam_24060 {

    static int[] tmp;           // 병합 정렬 중 데이터를 임시로 담아둘 배열
    static int cnt = 0;         // 배열에 저장되는 횟수
    static int result = -1;     // k번째 저장되는 값을 담는 변수
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 배열 크기
        k = Integer.parseInt(st.nextToken());       // 저장 순서

        int[] a = new int[n];   // 원본 배열
        tmp = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        // 병합 정렬 시작
        mergeSort(a, 0, n - 1);

        // k번째 저장된 수가 없으면 -1
        System.out.println(result);
        
    }

    public static void mergeSort(int[] a, int p, int r) {
        if(p < r) {
            int q = (p + r) / 2;        // 중간 인덱스
            mergeSort(a, p, q);         // 왼쪽 정렬
            mergeSort(a, q+1, r);       // 오른쪽 정렬
            merge(a, p, q, r);          // 병합
        }
    }

    public static void merge(int[] a, int p, int q, int r) {
        int i = p;          // 왼쪽 배열 시작
        int j = q + 1;      // 오른쪽 배열 시작
        int t = 0;          // tmp 배열 인덱스

        // 왼쪽 오른쪽 배열을 비교해서 작은 값부터 tmp로 복사
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[t++] = a[i++];
            } else {
                tmp[t++] = a[j++];
            }
        }

        // 왼쪽 배열이 남아있다면 모두 tmp로 복사
        while (i <= q) {
            tmp[t++] = a[i++];
        }
        // 오른쪽 배열이 남아있다면 모두 tmp로 복사
        while (j <= r) {
            tmp[t++] = a[j++];
        }

        i = p; // a의 시작점
        t = 0; // tmp 배열 인덱스
        while (i <= r) {
            a[i] = tmp[t++];
            cnt++;  // 저장 횟수 증가

            // k번째 저장이면 result에 값 저장
            if (cnt == k) result = a[i];
            i++;
        }
    }
}
