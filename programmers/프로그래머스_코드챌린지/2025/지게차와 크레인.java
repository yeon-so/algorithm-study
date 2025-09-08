package programmers.프로그래머스_코드챌린지.2025;

import java.util.*;

public class 지게차와 크레인 {
     // 행
    static int n;
    // 열
    static int m;
    // 배열
    static int[][] arr;
    // 꺼낸 컨테이너
    static int outCnt;
    // 4방향
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] storage, String[] requests) {
        // 꺼낸 컨테이너 초기화
        outCnt = 0;
        
        // 행,열 초기화
        n = storage.length;
        m = storage[0].length();
        
        // 물류창고 배열로 초기화
        arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = storage[i].charAt(j) - 'A';
            }
        }
        
        // 요청만큼 반복
        for(String re : requests){
            int target = re.charAt(0) - 'A';
            if(re.length() == 1) {
                // 1. 지게차
                useJige(target);
            } else {
                // 2. 크레인   
                useCrain(target);
            }
        }
        
        // 결과 반환 (전체 컨테이너수 - 빠진 컨테이너수)
        return (n*m) - outCnt;
    }
    
    // 전체에서 target 제거
    static void useCrain(int target) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == target) {
                    arr[i][j] = -1;
                    outCnt++;
                } 
            }
        }
    }

    // 바깥쪽/빈 공간을 통해 접근 가능한 target만 제거
    static void useJige(int target){
        // 지개차가 접근 가능 : 1 / 접근 불가능(초기화) : -1 / 빈 공간 : 0
        // temp 변수 선언 및 초기화
        int[][] temp = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(temp[i], -1);
        }
        
        // 제거 후보용 리스트 선언
        // BFS용 큐 선언
        ArrayList<int[]> list = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        
        // BFS
        // n*m 반복
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // 테두리만 시작점은 패스
                if(i != 0 && j != 0 && i != n-1 && j != m-1) continue;
                // 이미 방문한 칸도 패스
                if(temp[i][j] != -1) continue;
                
                // arr[i][j]가 빈공간이 아니라면
                if(arr[i][j] != -1){
                    // 지개차가 접근 가능하도록 변경
                    temp[i][j] = 1;
                    // arr[i][j]이 target과 같다면 제거 후보 등록
                    if(arr[i][j] == target) {
                        list.add(new int[]{i, j});
                    }
                    continue;
                }
                
                // temp[i][j]를 빈공간으로
                temp[i][j] = 0;
                // queue에 넣기
                q.add(new int[]{i, j});

                // q가 비워질때까지 반복
                while(!q.isEmpty()){
                    // queue에서 꺼내기
                    int[] cur = q.poll();
                    // 4 방향
                    for(int k = 0; k < 4; k++) {
                        int nx = cur[0] + dx[k];
                        int ny = cur[1] + dy[k];
                        
                        // 범위를 넘어서면 패스
                        if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                        // temp[nx][ny]가 이미 방문했다면 패스
                        if(temp[nx][ny] != -1) continue;
                        
                        // arr[nx][ny] 가 비어있다면
                        if(arr[nx][ny] == -1){
                            // 빈공간으로 만들고 지점을 q에 저장
                            temp[nx][ny] = 0;
                            q.add(new int[]{nx, ny});
                        } else {
                            // 비어있지 않다면
                            // 지게차가 접근할 수 있도록 변경
                            temp[nx][ny] = 1;
                            // target과 같다면 제거 후보 등록   
                            if (arr[nx][ny] == target) {
                                list.add(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }
        // 제거   
        for (int[] next : list) {
            arr[next[0]][next[1]] = -1;
            outCnt++;
        }
    }
}
