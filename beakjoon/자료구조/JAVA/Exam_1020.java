package beakjoon.자료구조.JAVA;

import java.io.*;
import java.util.*;

// O(M*N)
public class Exam_1020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 1; i <= N; i++) { 
            dq.offerLast(i);
        }

        String[] indexs = br.readLine().split(" ");

        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(indexs[i]);

            // target이 있는 현재 deque의 index
            // LinkedList로 정의했다면 IndexOf(target) 함수 사용
            int idx = 0;
            for(int val : dq) {
                if (val == target) break;
                idx++;
            }

            int size = dq.size();
            if(idx <= size / 2) {
                // 왼쪽 이동
                for (int j = 0; j < idx; j++) {
                    dq.addLast(dq.pollFirst());
                    result++;
                }
            } else {
                // 오른쪽 이동
                // for(int j = 0; j < size - idx; j++)
                for (int j = size; j > idx; j--) {
                    dq.addFirst(dq.pollLast());
                    result++;
                }
            }

            dq.pollFirst();

        }

        System.out.println(result);
        

    }
}
