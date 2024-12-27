package beakjoon.그래프.JAVA;

import java.util.*;
import java.io.*;

public class Exam_2644 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N+1][N+1];

        int[] visited = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        int V = Integer.parseInt(br.readLine());

        for(int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        Queue<Integer> q = new LinkedList();
        q.offer(first);
        visited[first] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for(int i = 0; i <= N; i++) {
                if(arr[cur][i] == 1 && visited[i] < 1) {
                    visited[i] += visited[cur] + 1;
                    if(i == second){
                        break;
                    }
                    q.offer(i);
                }
            }
        }

        System.out.println(visited[second] -1);
    }
}
