package programmers.KAKAO.2025;

public class 유연근무제 {
        public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        int sun = 7 - startday;
        int sat = 6 - startday < 0 ? 6 : 6 - startday;
        

        for(int i = 0; i < schedules.length; i++) {
            int cnt = 0;
            int mockpyo = schedules[i];
            for(int j = 0; j < timelogs[i].length; j++) {
                if(j == sun || j == sat) continue;
                int hour = mockpyo/100;
                int min = mockpyo%100;
                if(min < 50) {
                    if(timelogs[i][j] <= mockpyo + 10) {
                        cnt++;
                    }
                } else {
                    if(timelogs[i][j] <= (hour + 1) * 100 + (min + 10) % 60 ) {
                        cnt++;
                    }
                }
            }
            if(cnt == 5) {
                answer++;
            }
        }
        
        return answer;
    }
}
