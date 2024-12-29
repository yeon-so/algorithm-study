package beakjoon.그래프.JAVA;

import java.util.*;
import java.io.*;
import java.lang.Math;

public class Exam_9205 {

    static class Point {
        public int x; 
        public int y;
    
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Point[] store = new Point[100];
    static Point home;
    static Point goal;
    static boolean[] visit = new boolean[100];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t > 0){
            Arrays.fill(visit, false);
            t--;

            int n = Integer.parseInt(br.readLine());

            for(int i = 0; i < n+2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if(i == 0) {
                    home = new Point(x, y);
                } else if(i == n+1){
                    goal = new Point(x, y);
                } else {
                   store[i-1] = new Point(x, y);
                }
            }

            boolean flag = false;
            Queue<Point> q = new LinkedList<>();
            q.offer(home);

            while (!q.isEmpty()) {
                Point cur = q.poll();
                int x = cur.x;
                int y = cur.y;

                if(Math.abs(goal.x - x) + Math.abs(goal.y - y) <= 1000){
                    flag = true;
                    break;
                }

                for(int i = 0; i < n; i++){
                    if(!visit[i] && Math.abs(store[i].x - x) + Math.abs(store[i].y- y) <= 1000){
                        visit[i] = true;
                        q.offer(store[i]);
                    }
                }
            }

            if(flag){
                System.out.println("happy");
            }else{
                System.out.println("sad");
            }
        
        }
    
    }
}
