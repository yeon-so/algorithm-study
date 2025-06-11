package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Exam_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for(char ch : br.readLine().toCharArray()) {
            left.push(ch);
        }

        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++) {
            String command = br.readLine();
            char op = command.charAt(0);

            switch (op) {
                case 'L':
                    if(!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    break;
                case 'D':
                    if(!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    break;
                case 'B':
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    break;
                case 'P':
                    char ch = command.charAt(2);
                    left.push(ch);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : left) sb.append(ch);
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb.toString());
    }
}
