package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

// *다시 풀어볼 것* 
public class Exam_3015 {

    static class Node {
        int h;
        int cnt;

        public Node(int h, int cnt) {
            this.h = h;
            this.cnt = cnt;
        }
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        long result = 0;

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Deque<Node> stack = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            
            // 연속된 수
            int sameCnt = 1;

            // 나보다 작은 키를 가진 사람은 pop
            while (!stack.isEmpty() && stack.peek().h < arr[i]) {
                result += stack.pop().cnt;
            } 

            // 같은 키는 묶음
            if (!stack.isEmpty() && stack.peek().h == arr[i]) {
                Node node = stack.pop();
                result += node.cnt;
                sameCnt += node.cnt;
            }

            // 나보다 큰 사람이 있으면 쌍 추가
            if (!stack.isEmpty()) {
                result += 1;
            }

            stack.push(new Node(arr[i], sameCnt));
        }

        System.out.println(result);
    }
}
