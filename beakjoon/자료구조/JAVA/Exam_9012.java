package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Exam_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String temp = br.readLine();

            Stack<Character> stack = new Stack<>();

            if(temp.charAt(0) == ')') {
                System.out.println("NO");
                continue;
            }

            stack.push(temp.charAt(0));

            for(int j = 1; j < temp.length(); j++) {
                if(!stack.isEmpty() && stack.peek() == '(' && temp.charAt(j) == ')') {
                    stack.pop();
                } else {
                    stack.push(temp.charAt(j));
                }
            }

            if(stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
}
