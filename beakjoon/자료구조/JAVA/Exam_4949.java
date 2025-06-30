package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Exam_4949 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if(str.equals(".")) break;

            Stack<String> stack = new Stack<>();

            String[] temp = str.split("");
            for(String word : temp) {
                switch (word) {
                    case "(":
                        stack.push(word);
                        break;
                    case "[":
                        stack.push(word);
                        break;
                    case ")":
                        if(!stack.isEmpty() && stack.peek().equals("(")){
                            stack.pop();
                        } else {
                            stack.push(")");
                        }
                        break;            
                    case "]":
                        if(!stack.isEmpty() && stack.peek().equals("[")){
                            stack.pop();
                        } else {
                            stack.push("]");
                        }
                        break;
                    default:
                        break;
                }
            }

            if(stack.empty()) {
                System.out.println("yes\n");
            } else { 
                System.out.println("no\n");
            }
        }
    }
}
