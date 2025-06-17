package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Exam_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] result = new int[N];

        String[] temp = br.readLine().split(" ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }
 
        Deque<Integer> stack = new LinkedList<>();

        for(int i = N - 1; i >= 0; i--) {
            
            while(!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            stack.push(arr[i]);

        }

        StringBuilder sb = new StringBuilder();

        for(int a : result) {
            sb.append(a).append(" ");
        }

        System.out.println(sb.toString());
 
    }
}
