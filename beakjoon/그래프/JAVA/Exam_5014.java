package beakjoon.그래프.JAVA;

import java.util.*;
import java.io.*;

public class Exam_5014 {
    static int floor;
    static int start;
    static int goal;
    static int up;
    static int down;

    public static void main(String[] arge) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        floor = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());
        up = Integer.parseInt(st.nextToken());
        down = Integer.parseInt(st.nextToken());

        int[] building = new int[floor];
        int[] dist = new int[floor];
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(start-1);
        dist[start-1] = 1;

        boolean flag = false;
        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur == goal-1){
                flag = true;
                break;
            }

            for(int i: new int[] {cur + up, cur - down}){
                if(i >= floor || i < 0) continue;
                if(dist[i] > 0) continue;

                q.offer(i);
                dist[i] = dist[cur] + 1;
            }
        }

        int result = 0;
        if(flag){
            System.out.println(dist[goal-1]-1);
        } else {
            System.out.println("use the stairs");
        }


    }
}
