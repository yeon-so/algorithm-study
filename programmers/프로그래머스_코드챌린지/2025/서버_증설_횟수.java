public class 서버_증설_횟수 {
    public static int solution(int[] players, int m, int k) {
        
        int active = 0;
        int answer = 0;
        int len = players.length;
        int[] needServers = new int[len];
        int[] expire = new int[len+k+1];
        
        for(int i = 0; i < len; i++) {
            needServers[i] = players[i] / m;
        }
        
        for(int i = 0; i < len; i++) {
            
            active -= expire[i];
            
            if(active < needServers[i]) {
                int temp = needServers[i] - active;
                active += temp;
                answer += temp;
                expire[i+k] += temp; 
            }
        }
        
        return answer;
    }

    public static void main(String[] args) {
        int[] players = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        int m = 3;
        int k = 5; 

        System.out.println(solution(players, m, k));

    }
}
