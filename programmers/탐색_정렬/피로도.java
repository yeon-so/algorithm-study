public class 피로도 {
    static boolean[] visited;
    static int temp = 0;
    
    static public void func(int cnt, int k, int[][] dungeons){
        for(int i = 0; i < dungeons.length; i++){
            if(dungeons[i][0] > k || visited[i]) continue;
            visited[i] = true;
            func(cnt + 1, k - dungeons[i][1], dungeons);
            visited[i] = false;
        }
        temp = Math.max(cnt, temp);
    }
    
    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];
        
        func(0,k,dungeons);
        return temp;
    }
}
