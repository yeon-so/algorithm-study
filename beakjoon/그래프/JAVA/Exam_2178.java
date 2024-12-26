package beakjoon.그래프.JAVA;

import java.util.*;
import java.io.*;

public class Exam_2178 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][] dist = new int[N][M];
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<int[]> q = new LinkedList<>();
        dist[0][0] = 1;
        q.offer(new int[] {0,0});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int X = cur[0];
            int Y = cur[1];
            
            for(int i = 0; i < 4; i++){
                int nx = dx[i] + X;
                int ny = dy[i] + Y;

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(dist[nx][ny] >= 1 || arr[X][Y] == 0) continue;

                dist[nx][ny] = dist[X][Y] + 1;
                q.offer(new int[] {nx,ny});
            }
        }

        System.out.println(dist[N-1][M-1]);

    }
    
}
