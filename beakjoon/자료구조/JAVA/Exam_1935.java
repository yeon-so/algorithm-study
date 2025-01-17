package beakjoon.자료구조.JAVA;

import java.util.*;
import java.io.*;

public class Exam_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int cnt = Integer.parseInt(br.readLine()); // 피연산자의 숫자
        String prefix = br.readLine(); // 후위 표기식

        int[] arr = new int[cnt];
        for(int i = 0; i < cnt; i++) {
            int temp = Integer.parseInt(br.readLine());
            arr[i] = temp;
        }

        Deque<Double> stack = new ArrayDeque<>();
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i); // A ~ Z
            if(c >= 'A' && c <= 'Z') {
                stack.push((double)arr[c - 'A']);
            } else {
                double n1 = stack.pop();
                double n2 = stack.pop();
                double tmp = 0.0;

                if(c == '+') {
                    tmp = n2 + n1;
                } else if(c == '-') {
                    tmp = n2 - n1;
                } else if(c == '*') {
                    tmp = n2 * n1;
                } else {
                    tmp = n2 / n1;
                }

                stack.push(tmp);
            }
        }

        System.out.printf("%.2f\n",stack.pop());

    }
}
