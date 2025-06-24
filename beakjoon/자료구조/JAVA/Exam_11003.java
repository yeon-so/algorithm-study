package beakjoon.자료구조.JAVA;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Exam_11003 {

    public static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Deque<Node> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());

            // 범위를 벗어났다면 삭제
            while (!dq.isEmpty() && dq.peekFirst().index < i - L + 1) {
                dq.pollFirst();
            }

            // 덱의 마지막부터 현재 값보다 큰 값이 있다면 삭제
            while (!dq.isEmpty() && dq.getLast().value > temp) {
                dq.pollLast();
            }

            // 덱의 마지막의 현재 값 추가
            dq.offerLast(new Node(i, temp));

            // 덱의 첫번째 값이 최솟값
            sb.append(dq.peekFirst().value).append(" ");
        }

        System.out.println(sb.toString());

    }
}
