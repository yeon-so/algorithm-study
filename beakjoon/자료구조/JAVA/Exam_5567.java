package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam_5567 {

    // 인접행렬이 아닌 인접리스트로 표현
    static ArrayList<Integer>[] list;
    // 거리
    static int[] dist;
    // 방문 여부
    static boolean[] visit;
    // 결과값
    static int result = 0;
    
    static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        visit[1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if(dist[cur] < 2) {
                for(int a : list[cur]){
                    if(!visit[a]) {
                        dist[a] = dist[cur] + 1;
                        visit[a] = true;
                        q.offer(a);
                        result++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;

        list = new ArrayList[n+1];
        dist = new int[n+1];
        visit = new boolean[n+1];

        for(int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            list[v].add(u);
        }

        bfs();

        System.out.println(result);
    }
}
