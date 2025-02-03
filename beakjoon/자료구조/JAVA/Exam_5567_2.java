package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Exam_5567_2 {

    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static int result = 0;
    
    static void dfs(int cur, int dist) {
        if(dist == 2){
            return;
        } 

        for(int a : list[cur]){
            if(!visit[a]) result++;
            visit[a] = true;
            dfs(a, dist+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;

        list = new ArrayList[n+1];
        visit = new boolean[n+1];

        for(int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            list[v].add(u);
            list[u].add(v);
        }

        visit[1] = true;
        dfs(1, 0);

        System.out.println(result);
    }
}
