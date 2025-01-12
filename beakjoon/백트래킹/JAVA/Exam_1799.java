package beakjoon.백트래킹.JAVA;

import java.util.*;
import java.io.*;

public class Exam_1799 {

    static int size;
    static int[][] board;
    static int bCnt = 0;
    static int wCnt = 0;

    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {-1, 1, -1, 1};

    static void funcBlack(boolean[][] visited, int cur, int x, int y) {
        // 비숍 개수 갱신
        bCnt = Math.max(cur, bCnt);

        // 한 줄 검사 완료 시 다음 줄로
        if(y > size) {
            x += 1;
            if(x%2 == 0){
                y = 2;
            } else {
                y = 1;
            }
        }

        // 모두 다 돌았다면 return
        if(x > size) {
            return;
        }
        
        // 비숍을 둘 수 있는 지 확인해서 유효하다면 다음 칸으로 
        if(isValid(visited, x, y)){
            visited[x][y] = true;
            funcBlack(visited, cur+1, x, y+2);
            visited[x][y] = false;
        }

        // 비숍을 둘 수 없다면 cur을 그대로
        funcBlack(visited, cur, x, y+2);
    }

    static void funcWrite(boolean[][] visited, int cur, int x, int y) {
        // 비숍 개수 갱신
        wCnt = Math.max(cur, wCnt);

        // 한 줄 검사 완료 시 다음 줄로
        if(y > size) {
            x += 1;
            if(x%2 == 0){
                y = 1;
            } else {
                y = 2;
            }
        }

        // 모두 다 돌았다면 return
        if(x > size) {
            return;
        }
        
        // 비숍을 둘 수 있는 지 확인해서 유효하다면 다음 칸으로 
        if(isValid(visited, x, y)){
            visited[x][y] = true;
            funcWrite(visited, cur+1, x, y+2);
            visited[x][y] = false;
        }

        // 비숍을 둘 수 없다면 cur을 그대로
        funcWrite(visited, cur, x, y+2);
    }

    static boolean isValid(boolean[][] visited, int x, int y) {

        if(board[x][y] == 0) return false;
            
        for(int i=0; i < 4; i ++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            
            for(int j=0; j <size; j++) {
                if(nx > 0 && ny > 0 && nx <= size && ny <= size) {
                    if(visited[nx][ny]) return false;
                    
                    nx += dx[i];
                    ny += dy[i];
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine()); 
        board = new int[size+1][size+1];
        boolean[][] visitBlack = new boolean[size+1][size+1];
        boolean[][] visitWhite = new boolean[size+1][size+1];
        
        for(int i = 1; i <= size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= size; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        funcBlack(visitBlack, 0,1,1);
        funcWrite(visitWhite, 0,1,2);

        System.out.println(bCnt + wCnt);
    }   
}