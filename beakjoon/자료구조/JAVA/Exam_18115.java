package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Exam_18115 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        // 역순으로 넣기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = n; i > 0; i--) {
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
        }

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 1; i <= n; i++) {
            // 카드 맨 위에 올리기
            if(arr[i] == 1) {
                deque.addFirst(i);
            // 카드 위의 두번째에 두기
            } else if (arr[i] == 2) {
                int temp = deque.pollFirst();
                deque.addFirst(i);
                deque.addFirst(temp);
            // 카드 마지막에 두기
            } else {
                deque.addLast(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst()).append(" ");
        }

        System.out.println(sb);
    

    }
}
