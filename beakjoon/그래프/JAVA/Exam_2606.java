package beakjoon.그래프.JAVA;

import java.util.*;
import java.io.*;

public class Exam_2606 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] arr = new int[N+1][N+1];
        boolean[] v = new boolean[N+1];

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        v[1] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i = 1; i <= N; i++){
                if(!v[i] && arr[cur][i] == 1){
                    v[i] = true;
                    count++;
                    q.offer(i);
                }
            }
        }

        System.out.println(count);

    }
    
}
