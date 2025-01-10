import java.io.*;
import java.util.*;

public class Exam_18809 {

    static final int RED = 1;
    static final int GREEN = 2;
    static final int FLOWER = 3;

    static int N;
    static int M;

    // 빨 초 배양액 1 ~ 5개
    static int G;
    static int R;

    static int[][] garden;
    static ArrayList<int[]> pos = new ArrayList<>(); // 배양액을 뿌릴 수 있는 좌표

    static int[] posG;
    static int[] posR;
    static boolean[] isUsed;
    
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int result = 0;

    static class Element{
        public int time;
        public int type;

        public Element() {
        }

        public Element(int time, int type) {
            this.time = time;
            this.type = type;
        }
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        Element[][] state = new Element[N][M];
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                state[i][j] = new Element();
            }
        }

        for(int i = 0; i < G; i++){
            int[] p = pos.get(posG[i]);
            state[p[0]][p[1]] = new Element(0, GREEN);
            q.offer(p);
        }

        for(int i = 0; i < R; i++){
            int[] p = pos.get(posR[i]);
            state[p[0]][p[1]] = new Element(0, RED);
            q.offer(p);
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int curTime = state[x][y].time;
            int curType = state[x][y].type;

            // 꽃이 이미 핀 자리라면 퍼지지 않음
            if(curType == FLOWER) continue;

            for(int i = 0; i < 4; i ++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 가 아니면 퍼지지 않음
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                // 호수라면 퍼지지 않음
                if(garden[nx][ny] == 0) continue;

                // 아직 퍼지지 않았다면 퍼트림
                if(state[nx][ny].type == 0) {
                    state[nx][ny] = new Element(curTime+1, curType);
                    q.offer(new int[] {nx,ny});
                } else if(state[nx][ny].type == GREEN) {
                    if(curType == RED && state[nx][ny].time == curTime+1){
                        cnt++;
                        state[nx][ny].type = FLOWER;
                    }
                } else if(state[nx][ny].type == RED) {
                    if(curType == GREEN && state[nx][ny].time == curTime+1){
                        cnt++;
                        state[nx][ny].type = FLOWER;
                    }
                }
            }
            
        }

        result = Math.max(cnt, result);

    }

    static void initR(int st, int cur) {
        if(cur ==R) {
            bfs();
            return;
        }

        for(int i = st; i < pos.size(); i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                posR[cur] = i;
                initR(i+1, cur+1);
                isUsed[i] = false;
            }
        }
    }

    static void initG(int st, int cur) {
        if(cur == G) {
            initR(0,0);
            return;
        }

        for(int i = st; i < pos.size(); i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                posG[cur] = i;
                initG(i+1, cur+1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        garden = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                garden[i][j] = temp;
                if(temp == 2) pos.add(new int[] {i,j});
            }
        }

        isUsed = new boolean[pos.size()];
        posG = new int[G];
        posR = new int[R];

        initG(0,0);

        System.out.println(result);
    }
}
