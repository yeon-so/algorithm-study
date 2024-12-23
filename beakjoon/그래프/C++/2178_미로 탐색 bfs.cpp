#include<iostream>
#include<queue>
#include<string>

using namespace std;

// 맵
int map[101][101];
// 방문 표시
int visited[101][101];
// 큐
queue<pair<int,int>> q;
// N 세로 M 가로
int N, M;
// 상,하,좌,우
int dx[4] = {0,1,0,-1};
int dy[4] = {-1,0,1,0};

void bfs(int start_x, int start_y)
{
	// 현재 지점 방문 처리
	visited[start_x][start_y] = 1;
	// 큐에 현재 지점 삽입
	q.push({start_x,start_y});

	while (!q.empty())
	{
		// 큐의 현재 원소 꺼내기 
		int y = q.front().first;
		int x = q.front().second;
		q.pop();

		for(int i = 0; i < 4; i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 범위 안인지 확인
			if(nx < 0 || ny < 0 || nx >= M || ny >= N)
				continue;

			// 아직 방문하지 않았고 갈 수 있는 길이면
			if(visited[ny][nx] == 0 && map[ny][nx] == 1)
			{
				visited[ny][nx] = visited[y][x] + 1;
				q.push({ny,nx});
			}
		}
	}	
}

int main()
{
	cin >> N >> M;

	for(int i = 0; i < N; i++)
	{
		string temp;
		cin >> temp;
		for(int j = 0; j < M; j++)
		{
			map[i][j] = temp[j] - '0';
		}
	}

	bfs(0,0);

	cout << visited[N -1][M -1] << '\n';
}