package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Exam_1406_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Character> list = new LinkedList<>();

        for(char ch : br.readLine().toCharArray()) {
            list.add(ch);
        }

        ListIterator<Character> iter = list.listIterator();

        // 처음 커서는 끝으로
        while (iter.hasNext()) {
            iter.next();
        }

        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++) {
            String command = br.readLine();
            char op = command.charAt(0);

            switch (op) {
                case 'L':
                    if(iter.hasPrevious()) {
                    iter.previous();
                    }
                    break;
                case 'D':
                    if(iter.hasNext()) {
                        iter.next();
                    }
                    break;
                case 'B':
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    char ch = command.charAt(2);
                    iter.add(ch);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : list) sb.append(ch);
        System.out.println(sb.toString());
    }
}
