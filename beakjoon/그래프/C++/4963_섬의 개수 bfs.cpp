#include<iostream>
#include<cstring> // memset
#include<algorithm> // qair
#include<queue>

using namespace std;

int map[50][50] = { 0,};
int visited[50][50] = {0, };
queue<pair<int,int>> q;
// 상하좌우 + 대각선 이동 방향
int dx[8] = {-1, 0, 1, -1, 1, -1, 0 , 1};
int dy[8] = {1, 1, 1, 0, 0, -1, -1, -1};
int w, h;

void bfs(int x, int y)
{
	// 해당 지점 q에 삽입
	q.push({x,y});
	// 해당 지점 방문 처리
	visited[x][y] = 1; 

	//큐가 빌때까지 반복
	while(!q.empty())
	{
		// 큐 맨 앞 값의 x,y 값 변수 선언
		int tx = q.front().first;
		int ty = q.front().second;

		// 큐에서 앞 값 제거
		q.pop();

		// 상하좌우대각선 검사
		for(int i = 0; i < 8; i++)
		{
			int nx = tx + dx[i];
			int ny = ty + dy[i];

			//범위 밖이면 탈출
			if( nx < 0 || ny < 0 || nx >= h || ny >= w )
				continue;

			//해당 지점을 방문하지 않았고 그 위치가 섬이라면
			if(visited[nx][ny] == 0 && map[nx][ny] == 1)
			{
				// 해당 지점 q에 삽입
				q.push({nx,ny});
				// 해당 지점 방문 처리
				visited[nx][ny] = true;
			}

		}
	}

}

int main()
{

	while (true)
	{
		int cnt = 0;

		cin >> w >> h;

		// 두 수가 0 이면 종료
		if(w == 0 && h == 0)
		{
			break;;
		}

		// 지도 채우기
		for(int i = 0; i < h; i++)
		{
			for(int j = 0; j < w; j++)
			{
				int temp;
				cin >> temp;
				map[i][j] = temp;
			}
		}

		//섬의 갯수 구하기
		
		for(int i = 0; i < h; i++)
		{
			for(int j = 0; j < w; j++)
			{
				// 해당 구역이 땅이고 방문하지 않았다면 dfs 호출
				if( visited[i][j] == 0 && map[i][j] == 1)
				{
					bfs(i,j);
					cnt++;
				}
		
			}
		}

		// 결과 출력
		cout << cnt << '\n';
		// 배열 초기화
		memset(visited, 0, sizeof(visited));
	}
	

}