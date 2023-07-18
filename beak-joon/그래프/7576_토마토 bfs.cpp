#include <iostream>
#include <queue>

using namespace std;

int graph[1001][1001] = {0,};
queue<pair<int, int>> q;
int result = 0;

//방향
int dx[] = {-1,0,1,0};
int dy[] = {0,1,0,-1};

int N, M;

void bfs()
{
	while(!q.empty()){
		// 큐의 현재 원소(익은 토마토) 꺼내기 
		int y = q.front().first;
		int x = q.front().second;
		q.pop();

		//해당 위치의 주변을 확인
		for( int i = 0; i < 4; i++ ){
			int ny = y + dy[i];
			int nx = x + dx[i];

			// 해당 위치의 주변을 확인
			if(ny < 0 || nx < 0 || ny >= N || nx >= M)
				continue; 

			// 익지않은 토마토라면
			if(graph[ny][nx] == 0 )
			{
				graph[ny][nx] = graph[y][x] + 1;
				q.push({ny,nx});
			}
		}		
	}
}

int main()
{
	// M 세로 칸의 수, N 가로 칸의 수
	cin >> M >> N;

	for(int i = 0; i < N; i++)
	{
		for(int j = 0; j < M; j++)
		{
			// 그래프 정보 입력 
			int x;
			cin >> x;
			graph[i][j] = x;
			// 익은 토마토는 큐에 삽입 
			if(graph[i][j] == 1 )
				q.push({i,j});
		}
	}

	bfs();

	// 안 익은 토마토 확인
	for(int i = 0; i < N; i++)
	{
		for(int j = 0; j < M; j++)
		{
			// 안 익은 토마토가 있을 경우
			if(graph[i][j] == 0)
			{
				cout << "-1" << '\n';
				return 0;
			}
			// 토마토 익은 날짜
			if(result < graph[i][j]){
				result = graph[i][j];
			}
		}
	}

	cout << result - 1 << '\n';

}