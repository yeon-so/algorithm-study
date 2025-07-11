package beakjoon.자료구조.JAVA;

import java.io.*;
import java.util.Stack;

public class Exam_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;

        for(int i = 0; i < n.length(); i++) {
            char temp = n.charAt(i);

            if(temp == '('){
                stack.push('(');
            }
            if(!stack.isEmpty() && temp == ')'){
                stack.pop();

                if(n.charAt(i-1) == '(') {
                    result += stack.size();
                } else {
                    result++;
                }
            }
        }

        System.out.println(result);
    }   
}
