package programmers.탐색_정렬;

import java.util.HashSet;
import java.util.Set;

// 백트래킹
public class 소수_찾기 {
    static public Set<Integer> set = new HashSet<>();
    static public boolean[] visited;  
    static public String[] split;
    
    public int solution(String numbers) {
        
        split = numbers.split("");
        visited = new boolean[split.length];
        int answer = 0;
        
        dfs(0, "");
        
        for(Integer e : set) {
            if(isPrime(e)) answer++;
        }
        
        return answer;
    }
    
    static boolean isPrime(int num) {
        if(num < 2) return false;
        for(int i = 2; i <= (int)Math.sqrt(num); i++) {
            if(num%i == 0) return false;
        }
        return true;
    }
    
    static void dfs(int depth, String cur) {
        if(depth > split.length) return;
        
        for(int i = 0; i < split.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                set.add(Integer.valueOf(cur+split[i]));
                dfs(depth+1,cur+split[i]);
                visited[i] = false;
            }
        }
    }
}
