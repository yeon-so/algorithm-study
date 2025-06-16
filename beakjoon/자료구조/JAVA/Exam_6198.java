package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Exam_6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long result = 0;

        int[] buildings = new int[N];

        for(int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(br.readLine());
        }

        Deque<Integer> stack = new LinkedList<>();

        // 왼쪽 건물부터
        for(int i = 0; i < N; i++) {
            // 현재 대상보다 낮은 건물은 제거
            while(!stack.isEmpty() && stack.peek() <= buildings[i]) {
                stack.pop();
            }

            // 남은 stack 수 = 현재 대상의 옥상을 볼 수 있는 건물 수
            result += stack.size();
            stack.push(buildings[i]);
            
        }

        System.out.println(result);

    }   
}
