package beakjoon.자료구조.JAVA;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Exam_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();
            
            for(char c : br.readLine().toCharArray()) {
                if(c == '<') {
                    if(iter.hasPrevious()){
                        iter.previous();
                    }
                } else if (c == '>') {
                    if(iter.hasNext()){
                        iter.next();
                    }
                } else if (c == '-') {
                    if(iter.hasPrevious()){
                        iter.previous();
                        iter.remove();
                    }
                } else { 
                    iter.add(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            for(char ch : list) sb.append(ch);
            System.out.println(sb.toString());
        }
    }
}
