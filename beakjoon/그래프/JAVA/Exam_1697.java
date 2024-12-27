package beakjoon.그래프.JAVA;

import java.util.*;
import java.io.*;

public class Exam_1697 {
    public static final int size = 100001;
    public static void main(String[] args) throws IOException {

        int[] b = new int[size];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        b[N] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if(cur == K) break;
            
            for (int nxt : new int[] {cur - 1, cur + 1, cur * 2}) {
                if (nxt < 0 || nxt > size-1) continue;
                if (b[nxt] != 0) continue;
                
                b[nxt] = b[cur] + 1;
                q.add(nxt);
            }
        }

        System.out.println(b[K] - 1); 
    }
}
