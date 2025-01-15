package beakjoon.자료구조.JAVA;

import java.util.*;
import java.io.*;

public class Exam_2493 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int[] tops = new int[cnt];
        int[] result = new int[cnt];

        String[] temp = br.readLine().split(" ");        

        for(int i = 0; i < cnt; i++) {
            tops[i] = Integer.parseInt(temp[i]);
        }

        Deque<Integer> stack = new LinkedList<>();

        for(int i = 0; i < cnt; i++) {

            while (!stack.isEmpty() && tops[i] > tops[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i] = 0;
            } else {
                result[i] = stack.peek() + 1;
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cnt; i++) {
            sb.append(result[i]).append(" ");
        }
        sb.append("\n");

        System.out.println(sb);
    
        
    }

}
