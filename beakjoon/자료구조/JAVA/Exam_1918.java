package beakjoon.자료구조.JAVA;

import java.util.*;
import java.io.*;

public class Exam_1918 {
    public static void main(String[] args) throws IOException {
        // 우선 순위가 낮은 연산자부터 쌓아야 한다. (낮음 (, + - , */ 높음)
        // )는 (까지 다 꺼낸다.
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Deque<Character> stack = new LinkedList<>();

        for(int i = 0; i < arr.length; i++) {
            // 연산자 외에는 바로 출력
            if(arr[i] >= 'A' && arr[i] <= 'Z'){
                sb.append(arr[i]);
            } else {
                if(arr[i] == '+' || arr[i] == '-'){
                    // 우선 순위가 높거나 같은 경우까지 출력
                    while (!stack.isEmpty() && (stack.peek() != '(')) {
                        sb.append(stack.peek());
                        stack.pop();
                    }
                    stack.push(arr[i]);
                } else if(arr[i] == '*' || arr[i] == '/') {
                    // 우선 순위가 높거나 같은 경우까지 출력
                    while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                        sb.append(stack.peek());
                        stack.pop();
                    }
                    stack.push(arr[i]);
                // ( 은 우선 순위가 가장 낮으므로 바로 스택에 넣음
                } else if(arr[i] == '(') {
                    stack.push(arr[i]);
                // ) 일 경우 ( 전까지 출력 후 ( 꺼냄
                } else if(arr[i] == ')') {
                    while (!stack.isEmpty() && (stack.peek() != '(')) {
                        sb.append(stack.peek());
                        stack.pop();
                    }
                    stack.pop();
                }
            }
        }
        // 남은 스택 처리
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
