package beakjoon.그래프.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Exam_16954 {

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static final int LENGTH = 8;
    public static char[][] board = new char[LENGTH][LENGTH];
    public static boolean[][] visited;

    public static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1, 0};
    public static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1, 0};

    // 1. 욱제의 캐릭터가 움직임 - 처음 위치 (7,0) / 상하좌우, 대각선, 현재위치
    // 2. 욱제가 먼저 이동하고나서 벽이 움직임, 현재 벽위치가 (n,m) 면 (n+1,m) 로
    // 3. 욱제의 캐릭터가 (0,7)로 갈 수 있다면 1, 그렇지 못하면 0
    public static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(7, 0));

        while(!queue.isEmpty()) {
            int size = queue.size();
            // 한 턴동안 중복된 칸을 가지 않도록 방문 처리
            visited = new boolean[LENGTH][LENGTH];

            // 캐릭터 움직임
            // 캐릭터를 한번 움직이고 나서 벽을 움직여야 하므로 queue의 size만큼 for문
            for(int i = 0; i < size; i++) {
                Node cur = queue.poll();

                if(board[cur.x][cur.y] == '#') continue;

                if(cur.x == 0 && cur.y == 7) {
                    return 1;
                }

                for(int j = 0; j < LENGTH + 1; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if(nx < 0 || ny < 0 || nx >= LENGTH || ny >= LENGTH) continue;

                    if(visited[nx][ny] || board[nx][ny] == '#') continue;

                    queue.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }

            // 벽 움직임
            // 주의할 점 : J를 0부터 시작하면 이미 이동한 벽을 .로 덮어쓰는 문제가 발생한다.
            for(int j = LENGTH - 1; j >= 0; j--) {
                for(int k = 0; k < LENGTH; k++) {
                    if(board[j][k] == '#'){
                        board[j][k] = '.';

                        if(j != LENGTH - 1) {
                            board[j + 1][k] = '#';
                        }
                    }
                }
            }

        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < LENGTH; i++) {
            String temp = br.readLine();
            board[i] = temp.toCharArray();
        }

        int ans = bfs();

        System.out.println(ans);

    }
}
