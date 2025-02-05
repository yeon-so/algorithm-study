package beakjoon.그래프.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam_2660 {

    static int N;
    static int[][] graph; // 친구 관계
    static int[] info; // 각 회원별 점수
    static int score = Integer.MAX_VALUE; // 회장 후보 점수

    static class Node {
        int n; // 회원 번호
        int s; // 회원 점수

        public Node(int n, int d) {
            this.n = n;
            this.s = d;
        }
    }

    static void func(int start) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        int s = 0;
        q.add(new Node(start, s));
        visited[start] = true;

        while (!q.isEmpty()) {
            Node curNode = q.poll();
            int cur = curNode.n;
            s = curNode.s;

            for(int i = 1; i <= N; i++) {
                if(graph[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(new Node(i, s + 1));
                }
            }
        }

        info[start] = s; // 회원 점수 기록
        score = Math.min(info[start], score); // 최저 점수 기록

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N+1][N+1];
        info = new int[N + 1];

        StringTokenizer st = null;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(x == -1 && y == -1) {
                break;
            }

            // 양뱡향 연결
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        // 각 회원별 점수 구하기
        for(int i = 1; i <= N; i++) {
            func(i);
        }

        // 회장 후보 구하기
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            if(info[i] == score) {
                list.add(i);
            }
        }

        // 결과 출력
        System.out.println(score + " " + list.size());
        for(int e : list) {
            System.out.print(e + " ");
        }

    
    }
}
