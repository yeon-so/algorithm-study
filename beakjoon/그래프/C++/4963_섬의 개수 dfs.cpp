#include <iostream>
#include <cstring>

using namespace std;

int map[50][50] = { 0,};
int visited[50][50] = {0, };
// 상하좌우 + 대각선 이동 방향
int dx[8] = {-1, 0, 1, -1, 1, -1, 0 , 1};
int dy[8] = {1, 1, 1, 0, 0, -1, -1, -1};
int w, h;

void dfs(int x, int y)
{
	// 상하좌우 + 대각선 조사
	for(int i = 0; i < 8; i++)
	{
		int nx = x + dx[i];
		int ny = y + dy[i];

		// 범위 밖이면 건너뜀
		if( nx < 0 || ny < 0 || nx >= h || ny >= w)
			continue;

		// 해당 구역이 땅이고 방문하지 않았다면 
		if( visited[nx][ny] == 0 && map[nx][ny] == 1)
		{
			// 해당 지점 방문 처리
			visited[nx][ny] = 1;
			// 재귀
			dfs(nx,ny);
		}
	}
}

int main()
{
	while(true)
	{
		int cnt = 0;
		cin >> w >> h;

		// 입력 값이 0 0 이면 종료
		if(w == 0 && h == 0)
			break;

		for(int i = 0; i < h; i++)
		{
			for(int j = 0; j < w; j++)
			{
				int temp;
				cin >> temp;
				map[i][j] = temp;
			}
		}

		for(int i = 0; i < h; i++)
		{
			for(int j = 0; j < w; j++)
			{
				// 해당 구역이 땅이고 방문하지 않았다면 dfs 호출
				if( visited[i][j] == 0 && map[i][j] == 1)
				{
					//해당 지점 방문 처리
					visited[i][j] = 1;
					dfs(i,j);
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