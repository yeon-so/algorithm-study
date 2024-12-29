package beakjoon.그래프.JAVA;

import java.util.*;
import java.io.*;

public class Exam_14503 {

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int d = 0; // 북동남서
    static Point[] back = {
        new Point(1,0),
        new Point(0,-1),
        new Point(-1,0),
        new Point(0,1)
    };
    static Point[] front = {
        new Point(-1,0),
        new Point(0,1),
        new Point(1,0),
        new Point(0,-1)
    };
    static Point start;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int cnt = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] g = new int[N][M];
        boolean[][] clean = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        int tx = Integer.parseInt(st.nextToken());
        int ty = Integer.parseInt(st.nextToken());
        start = new Point(tx, ty);
        d = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                g[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()) {
            Point cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            
            // 1. 현재 칸이 아직 청소되지 않는 경우, 현재 칸을 청소한다.
            if(g[x][y] == 0 && !clean[x][y]) {
                //System.out.println(x + " " + y + " " + d) ;
                ++cnt;
                clean[x][y] = true;
            }
            
            boolean flag = false;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(!clean[nx][ny] && g[nx][ny] == 0){
                    flag = true;
                    break;
                }
                    
            }

            if(flag){
                // 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
                // 반시계 방향으로 회전
                for(int i = 0; i < 4; i++){
                        // 0 3 2 1 순
                        d = (d - 1 + 4) % 4;
                        
                        // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
                        int fx = x + front[d].x; 
                        int fy = y + front[d].y;
    
                        if(fx < 0 || fy < 0 || fx >= N || fy >= M) continue;
    
                        if(g[fx][fy] == 0 && !clean[fx][fy]){
                            q.offer(new Point(fx, fy));
                            break;
                        }
                }
            } else {
                // 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
                int bx = x + back[d].x; 
                int by = y + back[d].y;
                // 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                if(bx < 0 || by < 0 || bx >= N || by >= M) break;
                if(g[bx][by] == 1) break;
                // 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                q.offer(new Point(bx, by));
            }

        }

        System.out.println(cnt);
    }
}
