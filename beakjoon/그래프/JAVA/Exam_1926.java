package beakjoon.그래프.JAVA;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam_1926 {

    static int[][] paper;
    static int[][] vis;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int maxArea = 0;

        paper = new int[n][m];
        vis = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int temp = Integer.parseInt(st.nextToken());
                paper[i][j] = temp;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vis[i][j] == 0 && paper[i][j] == 1){
                    int tempArea = bfs(i, j);
                    maxArea = Math.max(maxArea, tempArea);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(maxArea);

    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        vis[x][y] = 1;
        int area = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            area++;

            for(int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if( nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(vis[nx][ny] == 1 || paper[nx][ny] == 0) continue;

                vis[nx][ny] = 1;
                q.add(new int[]{nx,ny});
            }
        }

        return area;
    }
}
