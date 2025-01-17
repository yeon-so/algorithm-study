package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class List {
    public int idx;
    public int priority;

    public List(int idx, int priority){
        this.idx = idx;
        this.priority = priority;
    }
}

public class Exam_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            
            t--;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
    
            st = new StringTokenizer(br.readLine());
            Deque<List> q = new ArrayDeque<>();
            for(int i = 0; i < n; i++) {
                int temp = Integer.parseInt(st.nextToken());
                q.offer(new List(i,temp));
            }

            int cnt = 0;
            while (true) {
                List cur = q.poll();
                boolean isHigh = true;

                for(List e : q) {
                    if(cur.priority < e.priority) {
                        isHigh = false;
                        break;
                    }
                }

                if(!isHigh){
                    q.offer(cur);
                } else {
                    cnt++;
                    if(cur.idx == target) break;
                }
            }

            System.out.println(cnt);

        }
    }
}
