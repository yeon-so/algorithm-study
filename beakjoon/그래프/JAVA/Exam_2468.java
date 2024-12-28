package beakjoon.그래프.JAVA;

import java.util.*;
import java.io.*;

public class Exam_2468 {
 
    // 문제를 반대로 생각해보면 강수량이 6 일때 6보다 큰 지역만 bfs로 확인 후 그 수를 세면 된다.
    // 범위는 1 ~ 가장 높은 높이까지
    // 문제에서는 써있지 않지만 비가 안올 경우도 생각해야한다. 강수량 0 일경우 -> result 를 1로 초기화 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] field = new int[n][n];
        int[][] temp = new int[n][n];

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        int max = 1;

        for(int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");
            for(int j =0; j < n; j++) {
                int h = Integer.parseInt(line[j]);
                
                if(max < h) {
                    max = h;
                }

                field[i][j] = Integer.parseInt(line[j]);
            }
        }

        int result = 1;
        for(int i = 1; i < max; i++) {

            int count = 0;
            for (int z = 0; z < n; z++) {
                Arrays.fill(temp[z], 0); 
            }
        
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    if(field[j][k] > i && temp[j][k] == 0) {
                        Queue<int[]> q = new LinkedList<>();
                        q.offer(new int[] {j,k});
                        temp[j][k] = 1;
                        count++;

                        while (!q.isEmpty()) {
                            int[] cur = q.poll();
                            int x = cur[0];
                            int y = cur[1];

                            for(int l = 0; l < 4; l++){
                                int nx = x + dx[l];
                                int ny = y + dy[l];

                                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                                if(field[nx][ny] <= i) continue;
                                if(temp[nx][ny] == 1) continue;

                                temp[nx][ny] = 1;
                                q.offer(new int[] {nx,ny});
                            
                            }
                        }
                    }
                }
            }
            if( result < count) result = count;
        }

        System.out.println(result);

        
    }
}
