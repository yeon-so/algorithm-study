package beakjoon.그래프.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Exam_11403 {
    
    static int N;
    // 인접 리스트 형태의 그래프
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int[][] result;


    // i -> j로 갈 수 있는 지 판별
    static void func(int n){

        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[N];
        q.add(n);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for(int e : arr.get(cur)) {
                if(!visit[e]) {
                    visit[e] = true;
                    result[n][e] = 1;
                    q.add(e);
                }
            }
        }
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = new int[N][N];

        for(int i = 0; i < N; i++) {
            arr.add(new ArrayList<>());
        }

        for(int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                int temp  = Integer.parseInt(str[j]);
                // i -> j 방향의 간선 존재 시 그래프에 추가
                if(temp == 1){
                    arr.get(i).add(j);
                }
            }
        }

        // 각 정점을 시작점으로 BFS 실행
        for(int i = 0; i < N; i++){
            func(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    
}
