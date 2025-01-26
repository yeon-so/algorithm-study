package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Exam_11478 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = i; j< s.length(); j++) {
                sb.append(s.charAt(j));
                String temp = sb.toString();
                set.add(temp);
            }
        }

        System.out.println(set.size());

    }   
}
