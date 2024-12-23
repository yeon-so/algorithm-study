package beakjoon.그래프.JAVA;

import java.io.*;
import java.util.*;

public class Exam_1260 {
    static int N, M, V;
    static int[][] g = new int[1001][1001];
    static boolean[] vis = new boolean[1001];

    static void dfs(int v){
        vis[v] = true;
        System.out.print(v + " ");

        for(int i = 0; i <= N; i++){
            if(g[v][i] == 1 && !vis[i]){
                dfs(i);
            }
        }
    }

    static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        vis[v] = true;
        System.out.print(v + " ");

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i = 0; i <= N; i++){
                if(g[cur][i] == 1 && !vis[i]){
                    vis[i] = true;
                    q.offer(i); 
                    System.out.print(i + " ");
                }
            }
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            g[x][y] = 1;
            g[y][x] = 1;
        }

        Arrays.fill(vis, false);
        dfs(V);
        System.out.println();

        Arrays.fill(vis, false);
        bfs(V);
        System.out.println();

    }
}