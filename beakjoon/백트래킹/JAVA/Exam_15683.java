package beakjoon.백트래킹.JAVA;

import java.io.*;
import java.util.*;

public class Exam_15683 {
    static class CCTV {
        public int x;
        public int y;
        public int type;

        public CCTV(int x, int y, int num){
            this.x = x;
            this.y = y;
            this.type = num;
        }
    }

    static int[][] board;
    static List<CCTV> cctvList;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N;
    static int M;
    static int ans = 0;

    static void copy(int[][] origin, int[][] copy) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = origin[i][j];
            }
        }
    }

    static void check(CCTV c, int dir) {
        int nx = c.x;
        int ny = c.y;
        
        while (true) {

            nx = nx + dx[dir];
            ny = ny + dy[dir];

            // 범위를 벗어나거나 벽을 만나면 종료
            if (nx < 0 || ny < 0 || nx >= N || ny >= M || board[nx][ny] == 6) {
                break;
            }

            // 이미 감시 중인 영역이면 지나침
            if (board[nx][ny] != 0) continue;

            // 감시 영역을 마킹
            board[nx][ny] = -1;
        }
    }

    static void dfs(int depth) {
        if(depth == cctvList.size()){
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            // 결과 계산
            ans = Math.min(ans, cnt);
            return;
        }

        // 백업 용
        int[][] backup = new int[N][M];
        CCTV cctv = cctvList.get(depth);

        switch (cctv.type) {
            case 1:
                // 한 방향만 감시
                for(int dir = 0; dir < 4; dir++){
                    // backup
                    copy(board, backup);
                    check(cctv, dir);
                    dfs(depth + 1);
                    // backup 내용 복구
                    copy(backup, board);
                }
                break;
            case 2:
                // 두 방향 감시 (서로 반대 방향)
                for(int dir = 0; dir < 2; dir++){
                    copy(board, backup);
                    check(cctv, dir);
                    check(cctv, (dir + 2) % 4);
                    dfs(depth + 1);
                    copy(backup, board);
                }
                break;
            case 3:
                // 두 방향 감시 (직각 방향)
                for(int dir = 0; dir < 4; dir++){
                    copy(board, backup);
                    check(cctv, dir);
                    check(cctv, (dir + 1) % 4);
                    dfs(depth + 1);
                    copy(backup, board);
                }
                break;
            case 4:
                // 세 방향 감시
                for(int dir = 0; dir < 4; dir++){
                    copy(board, backup);
                    check(cctv, dir);
                    check(cctv, (dir + 1) % 4);
                    check(cctv, (dir + 2) % 4);
                    dfs(depth + 1);
                    copy(backup, board);
                }
                break;
            case 5:
                // 네 방향 다 감시
                copy(board, backup);
                for(int dir = 0; dir < 4; dir++){
                    check(cctv, dir);
                }
                dfs(depth + 1);
                copy(backup, board);
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cctvList = new ArrayList<>();
        board = new int[N][M];

        for(int i = 0; i < N; i++){
            String[] temp = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(temp[j]);

                // CCTV 정보 저장
                if(board[i][j] != 0 && board[i][j] != 6) {
                    cctvList.add(new CCTV(i, j, board[i][j]));
                }

                // 빈공간의 갯수 세기
                if(board[i][j] == 0){
                    ans++;
                }
            }
        }

        // 결과가 0일 경우 더 이상 처리하지 않음
        if (ans == 0) {
            System.out.println(0);
            return;
        }

        dfs(0);
        System.out.println(ans);
    }
}
