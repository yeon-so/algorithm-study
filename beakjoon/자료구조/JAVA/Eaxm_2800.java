package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Eaxm_2800 {

    static class Pair {
        public int start;
        public int end;
        
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static ArrayList<Pair> list = new ArrayList<>();
    static ArrayList<String> result = new ArrayList<>();
    static boolean[] check = new boolean[10];
    static Set<String> visit = new HashSet<>();
    static boolean[] remove = new boolean[201];
    static String str;

    static void func(int idx, int cnt) {

        // 1개 이상 제거 됐을 시
        if(cnt >= 1) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < str.length(); i++) {
                if(!remove[i]) {
                    sb.append(str.charAt(i));
                }
            }

            // 중복 제거
            if(!visit.contains(sb.toString())) {
                visit.add(sb.toString());
                result.add(sb.toString());
            }
        }

        // 괄호 쌍을 하나씩 처리
        for(int i = idx; i < list.size(); i++) {
            if(!check[i]) {
                check[i] = true;
                remove[list.get(i).start] = true; // 제거
                remove[list.get(i).end] = true; // 제거
                func(i, cnt + 1);
                check[i] = false;
                remove[list.get(i).start] = false;
                remove[list.get(i).end] = false;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        Deque<Integer> dq = new ArrayDeque<>();


        // 괄호 구하기
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                dq.push(i);
            } else if(str.charAt(i) == ')') {
                int temp = dq.pop();
                list.add(new Pair(temp, i));
            }
        }
        
        // 괄호를 제거한 모든 식 출력
        func(0,0);

        // 정렬
        Collections.sort(result);
        for(String s : result) {
            System.out.println(s);
        }
    }

}
