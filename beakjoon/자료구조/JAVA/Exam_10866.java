package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Exam_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push_front" :
                    dq.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back" :
                    dq.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front" :
                    if(dq.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(dq.pollFirst());
                    }
                    break;
                case "pop_back" :
                    if(dq.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(dq.pollLast());
                    }
                    break;  
                case "size" :
                    System.out.println(dq.size());
                    break; 
                case "empty" :
                    System.out.println(dq.isEmpty() ? 1 : 0);
                    break;
                case "front" :
                    System.out.println(dq.isEmpty()  ? -1 : dq.peekFirst());
                    break;
                case "back" :
                    System.out.println(dq.isEmpty()  ? -1 : dq.peekLast());
                    break;
            }
        }
        
    }
}
