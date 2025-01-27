package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Exam_20166 {

    static int n; // 행
    static int m; // 열
    static int k; // 문자열 갯수

    static char[][] board;
    static ArrayList<String> strList = new ArrayList<>();
    static int[] dx = {-1,0,1,-1,1,-1,0,1};
    static int[] dy = {-1,-1,-1,0,0,1,1,1};

    static HashMap<String, Integer> map = new HashMap<>();

    static void dfs(int x, int y, int depth, String str){
        // 해당 문자열이 신이 좋아하는 문자에 속한다면 +1
        if(map.containsKey(str)){
            map.put(str, map.get(str) + 1);
        }

        // 1 ≤ 신이 좋아하는 문자열의 길이 ≤ 5
        if(depth == 5) {
            return;
        }

        // 8방향 이동
        for(int i = 0; i < dx.length; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            // 선형 처리
            if(nx < 0) {
                nx = n -1;
            } else if(nx >= n) {
                nx = 0;
            }

            // 선형 처리
            if(ny < 0) {
                ny = m -1;
            } else if(ny >= m) {
                ny = 0;
            }

            dfs(nx, ny, depth+1, str + board[nx][ny]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        for(int i = 0; i < n; i++) {
            String temp = br.readLine();
            for(int j = 0; j < m; j++) {
                board[i][j] = temp.charAt(j);
            }
        }

        for(int i = 0; i < k; i++) {
            String temp = br.readLine();
            map.put(temp, 0);
            strList.add(temp);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dfs(i, j, 1, Character.toString(board[i][j]));
            }
        }

        for(String str: strList) {
            System.out.println(map.get(str));
        }
    }
}
