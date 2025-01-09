package beakjoon.백트래킹.JAVA;

import java.util.*;
import java.io.*;

public class Exam_16987 {

    static class Egg {
        public int S;
        public int W;

        public Egg(int S, int W) {
            this.S = S;
            this.W = W;
        }
    }

    static int N;
    static ArrayList<Egg> eggs = new ArrayList<>();
    static int max = 0;

    static void func(int cnt, int cur) {
        // 마지막 계란까지 다 들었거나, 안깨진 계란이 1개만 남았다면
        if(cur == N || cnt == N - 1) {
            // 최댓값 갱신
            max = Math.max(max, cnt);
            return;
        }

        // 손에 든 계란이 깨졌으면 다음으로 넘김
        if(eggs.get(cur).S <= 0){
            func(cnt, cur + 1);
            return;
        }

        int temp = cnt;
        for(int i = 0; i < N; i++) {
            
            // 같은 계란 제외, 깨진 계란을 치려는 경우 다음으로 넘김
            if(cur == i || eggs.get(i).S <= 0) continue;

            // 두 계란을 부딪힘
            eggs.get(i).S -= eggs.get(cur).W;
            eggs.get(cur).S -= eggs.get(i).W;

            // 깨진 계란 체크
            if(eggs.get(i).S <= 0) {
                cnt++;
            }
            if(eggs.get(cur).S <= 0) {
                cnt++;
            }

            func(cnt, cur+1);

            // 원상복구
            eggs.get(i).S += eggs.get(cur).W;
            eggs.get(cur).S += eggs.get(i).W;
            cnt = temp;
        }  
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            Integer tempS = Integer.parseInt(st.nextToken());
            Integer tempW = Integer.parseInt(st.nextToken());

            eggs.add(new Egg(tempS, tempW));
        }

        func(0,0);

        System.out.println(max);
    }
}
