package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Exam_3986 {
    public static void main(String[] args) throws IOException {
    
        // ABAB = X, AABB = O, ABBA = O
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i = 0; i < n; i++) {
            String temp = br.readLine();

            Stack<Character> stack = new Stack<>();

            // 처음 글자는 스택에 넣는다.
            stack.push(temp.charAt(0));

            for(int j = 1; j < temp.length(); j++) {
                if(!stack.isEmpty() && stack.peek() == temp.charAt(j)) {
                    stack.pop();
                } else {
                    stack.push(temp.charAt(j));
                }
            }

            if(stack.isEmpty()) {
                result++;
            }
        }

        System.out.println(result);

    }
}
