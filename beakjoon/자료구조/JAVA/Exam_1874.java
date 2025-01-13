package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.io.IOException;

public class Exam_1874 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new LinkedList<>();

        int start = 0;
        for(int i = 0; i < num; i++) {
            int value= Integer.parseInt(br.readLine());

            if(value > start){
                for(int j = start+1; j <= value; j++) {
                    stack.push(j);
                    sb.append('+').append('\n');
                }
                start = value;
            } else if (value != stack.peekFirst()) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append('-').append('\n');
        }

        System.out.println(sb);
    }   
}
