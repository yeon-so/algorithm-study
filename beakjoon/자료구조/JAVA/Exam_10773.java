package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Exam_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new LinkedList<>();
        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++){
            int value = Integer.parseInt(br.readLine());

            if(value == 0) {
                stack.pop();
            } else {
                stack.push(value);
            }
        }

        int result = 0;
        for(int e : stack) {
            result += e;
        }

        System.out.println(result);
        
    }    
}
