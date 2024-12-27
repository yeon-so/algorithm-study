package beakjoon.그래프.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int h;
    int y;
    int x;

    public Point(int h, int y, int x){
        this.h = h;
        this.y = y;
        this.x = x;
    }
    
}

public class Exam_7569 {

    static int[] dx = {1,0,-1,0,0,0};
    static int[] dy = {0,1,0,-1,0,0};
    static int[] dh = {0,0,0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] arr = new int[H][Y][X];
        int[][][] v = new int[H][Y][X];

        for(int i = 0; i < H; i++){
            for(int j = 0; j < Y; j++){
                String[] str = br.readLine().split(" ");
                for(int k = 0; k < str.length; k++){
                    arr[i][j][k] = Integer.parseInt(str[k]);
                }
            }
        }

        Queue<Point> q = new LinkedList<>();

        for(int i = 0; i < H; i++){
            for(int j = 0; j < Y; j++){
                for(int k = 0; k < X; k++){
                    if(arr[i][j][k] == 1 && v[i][j][k] == 0){
                        q.offer(new Point(i, j, k));
                        v[i][j][k] = 1;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            Point cur = q.poll();
            
            for(int i = 0; i < 6; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nh = cur.h + dh[i];

                if(nx < 0 || ny < 0 || nh < 0 || nx >= X || ny >= Y || nh >= H) continue;

                if(arr[nh][ny][nx] == -1 || v[nh][ny][nx] > 0) continue;

                v[nh][ny][nx] = v[cur.h][cur.y][cur.x] + 1;
                q.offer(new Point(nh, ny, nx));
            }
        }

        int result = 0;
        int flag = 0;
        for(int i = 0; i < H; i++){
            for(int j = 0; j < Y; j++){
                for(int k = 0; k < X; k++){
                    if(v[i][j][k] == 0 && arr[i][j][k] != -1) {
                        flag = -1;
                        break;
                    }
                    if(result < v[i][j][k]) result = v[i][j][k];
                }
            }
        }

        if(flag == -1) result = 0; 
        System.out.println(result -1);
    }
}
