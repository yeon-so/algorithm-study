package beakjoon.백트래킹.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Exam_1941 {
    static char[][] map = new char[5][5];
    static boolean[][] used = new boolean[5][5];
    static Point[] result = new Point[7];
    static int cnt;
    
    // 인접한 방향
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
    }

    // 칠공주 모두가 인접한 지
    static boolean check() {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visit = new boolean[5][5];
        q.offer(result[0]);
        visit[result[0].x][result[0].y] = true;
        int tempCnt = 1;

        while(!q.isEmpty()){
            Point cur = q.poll();

            for(int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;

                if(used[nx][ny] && !visit[nx][ny]) {
                    tempCnt++;
                    visit[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                }
            }
        }


        if (tempCnt < 7) {
            return false;
        }
            
        return true;
    }

    // 칠공주 조합
    static void func(int idx, int cur, int yCnt) {
        if(yCnt >= 4) {
            return;
        }

        if(cur == 7){
            if(check()){
                cnt++;
            }
            return;
        }

        for(int i = idx; i < 25; i++) {
            int col = i/5;
            int row = i%5;

            used[col][row] = true;
            result[cur] = new Point(col,row);
                
            if(map[col][row] == 'S'){
                func(i+1, cur+1,yCnt);
            } else {
                func(i+1, cur+1,yCnt+1);
            }
            used[col][row] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 5; i++) {
            String str = br.readLine();
            for(int j = 0; j < 5; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        func(0, 0, 0);

        System.out.println(cnt);
    }
}