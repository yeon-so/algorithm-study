import java.util.LinkedList;
import java.util.Queue;

public class 전력망을_둘로_나누기 {
    class Solution {
    
    static int[][] graph;
    
    static int bfs(int n, int x) {
        boolean[] visited = new boolean[n+1];
        int cnt = 1;
        
        Queue<Integer> q = new LinkedList<Integer>();
        visited[x] = true;
        q.add(x);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i = 0; i <= n; i++) {
                if(graph[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                    cnt++;
                }
            }
        }
        
        return (int)Math.abs(cnt - (n - cnt));
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        graph = new int[n+1][n+1];
        
        for(int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }
        
        for(int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1][v2] = 0;
            graph[v2][v1] = 0;
            
            answer = Math.min(answer, bfs(n, v1));
            
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }
        
        return answer;
    }
}
