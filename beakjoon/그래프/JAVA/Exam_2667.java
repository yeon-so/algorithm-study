package beakjoon.그래프.JAVA;

import java.util.*;
import java.io.*;

public class Exam_2667 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        boolean[][] v = new boolean[N][N];
        ArrayList<Integer> r = new ArrayList<>();

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                arr[i][j] = line.charAt(j) - '0';
            }
        }
    
        int count1 = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] == 1 && !v[i][j]) {
                    int count2 = 1;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[] {i,j});
                    v[i][j] = true;

                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        int X = cur[0];
                        int Y = cur[1];

                        for(int k = 0; k < 4; k++) {
                            int nx = dx[k] + X;
                            int ny = dy[k] + Y;

                            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                            if(v[nx][ny] || arr[nx][ny] == 0) continue;

                            q.offer(new int[] {nx,ny});
                            v[nx][ny] = true;
                            ++count2;
                        }
                    }

                    r.add(count2);
                    count1++;
                }
            }
        }

        System.out.println(count1);
        Collections.sort(r);
        for(Integer i : r){
            System.out.println(i);
        }
    }

}
