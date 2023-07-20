#include <iostream>
#include <queue>
#include <cstring>
#include <algorithm>

using namespace std; 

int map[100][100] = {0,};
// 방문여부
int visited[100][100] = {0,};
int n;
int answer = 987654321;

int dx[4] = {0,0,1,-1};
int dy[4] = {1,-1,0,0};

void dfs(int x, int y, int l)
{
	// 해당 지점 번호(레벨링) 부여
	map[x][y] = l;

	for(int i = 0; i < 4; i++)
	{
		// 상하좌우 체크
		int nx = x + dx[i];
		int ny = y + dy[i];

		// 지도 범위 밖이면 패스
		if( nx < 0 || ny < 0 || nx >= n || ny >= n)
			continue;
		
		// 해당 지점이 번호가 부여되지 않은 섬이라면 재귀
		if(map[nx][ny] == -1)
			dfs(nx,ny,l);
	}
}

void bfs(int index)
{
	queue<pair<int,int>> q;
	for(int i = 0; i < n; i++)
	{
		for(int j = 0; j < n; j++)
		{
			// 레벨링된 섬이라면 큐에 몽땅 넣고 방문처리
			if(map[i][j] == index)
			{	
				q.push({i,j});
				visited[i][j] = 1;
			}
		}
	}

	// 섬과 섬의 거리가 n이면 다리길이는 n-1
	// 즉 섬의 거리가 1이면 다리 길이는 0이 나와 최소값인 0으로 초기화
	int result = 0;

	// Q가 비워질때까지 BFS 돌리기 
	while(!q.empty())
	{
		// q 길이
		int s = q.size();
		for(int i = 0; i < s; i++)
		{
			// 큐의 맨 앞값 제거
			int x = q.front().first;
			int y = q.front().second;
			q.pop();

			for(int j = 0; j < 4; j++)
			{
				// 상하좌우 체크
				int nx = x + dx[j];
				int ny = y + dy[j];

				// 지도 범위 밖이면 패스
				if( nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;

				
				// 다른 섬 도착했을 시 (바다가 아니고 현재 땅이 아니면)
				if(map[nx][ny] != index && map[nx][ny] != 0)
				{
					// 최소 거리 구하고 함수 빠져나가기
					answer = min(answer,result);
					return;
				}

				// 바다면서 방문한 적 없으면
				if(visited[nx][ny] == 0 && map[nx][ny] == 0)
				{
					// 방문처리
					visited[nx][ny] = 1;
					q.push({nx,ny});
				}
			}
		}
		result++;
	}

}

int main() 
{
	// 지도 크기 입력
	cin >> n;

	// 섬 입력받기
	for(int i = 0; i < n; i++)
	{
		for(int j = 0; j < n; j++)
		{
			cin >> map[i][j];
			// 각 섬마다 번호를 부여하기 위해서 모든 땅을 -1로 초기화
			if(map[i][j] == 1)
			{
				map[i][j] = -1;
			}
		}
	}


	// 섬마다 번호 부여하기
	// 섬 번호는 1부터 부여
	int index = 1;
	for(int i = 0; i < n; i++)
	{
		for(int j = 0; j < n; j++)
		{
			// 번호가 부여되지 않은 섬이라면
			if(map[i][j] == -1)
			{
				dfs(i,j,index);
				//섬 하나가 레벨링이 완료되었으면 번호 ++
				index++;
			}
		}
	}

	// 다리 최소 길이 구하기
	for(int i = 1; i < index; i++)
	{
		// 방문 여부 초기화
		memset(visited, 0, sizeof(visited));
		// i번째 섬의 최소 다리 길이
		bfs(i);
	}

	// 결과 출력
	cout << answer << '\n';
	
}