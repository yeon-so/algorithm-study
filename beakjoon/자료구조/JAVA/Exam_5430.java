package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Exam_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < t; i++) {
            String p = br.readLine();
            int size = Integer.parseInt(br.readLine());
            Deque<Integer> dq = new ArrayDeque<>();

            String b = br.readLine();
            b = b.substring(1, b.length() -1);
            String[] c = b.split(",");

            for(int j = 0; j < size; j++) {
                dq.offerLast(Integer.parseInt(c[j]));
            }

            boolean isReversed = false;
            boolean isError = false;
            for(char pp : p.toCharArray()) {
                if(pp == 'R') {
                    isReversed = !isReversed;
                } else {
                    if(dq.isEmpty()) {
                        System.out.println("error");
                        isError = true;
                        break;
                    }
                    if(isReversed) {
                        dq.pollLast();
                    } else {
                        dq.pollFirst();
                    }
                }
            }

            if(isError) {
                continue;
            }

            StringBuilder sb = new StringBuilder();

            sb.append("[");
            if(!dq.isEmpty()) {
                while(!dq.isEmpty()){
                    sb.append(isReversed ? dq.pollLast() : dq.pollFirst()).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append("]");

            System.out.println(sb.toString());
            
        }
    }   
}
