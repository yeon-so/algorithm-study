package beakjoon.정렬.JAVA;

import java.util.*;
import java.io.*;

/**
 * 이분 탐색 사용
 * list[x] + list[y] + list[z] = list[k]
 */

public class Exam_2295_2 {
    static int[] list;
    static int n;
    static HashSet<Integer> two = new HashSet<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new int[n];
        
        for(int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        // 두 수의 합을 저장
        // x, y, z, k는 모두 같아도 되므로 전체 탐색
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                two.add(list[i] + list[j]);
            }
        }


        // two[m] = list[l] - list[f]
        int result = 0;
        for(int l = n - 1; l > 0; l--) {
            for(int f = 0; f <= l; f++){
                int temp = list[l] - list[f];
                if(two.contains(temp)) {
                    result = Math.max(result, list[l]);
                }
            }
        }

        System.out.println(result);

    }
}
