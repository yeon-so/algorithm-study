package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Exam_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int temp = 1;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                temp *= 2;
            } else if(s.charAt(i) == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                }

                if(s.charAt(i-1) == '(') {
                    result += temp;
                }

                stack.pop();
                temp /= 2;
            } else if(s.charAt(i) == '[') {
                stack.push(s.charAt(i));
                temp *= 3;
            } else {
                if(stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }

                if(s.charAt(i-1) == '[') {
                    result += temp;
                }

                stack.pop();
                temp /= 3;
            }
        }

        if(!stack.empty()) {
            result = 0;
        }
        System.out.println(result);

    }   
}
