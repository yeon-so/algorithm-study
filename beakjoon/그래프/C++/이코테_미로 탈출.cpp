#include <iostream>
#include <queue>

using namespace std;

// 미로 
int miro[201][201];
int n, m;

// 상하좌우
int dx[] = { -1, 1, 0, 0};
int dy[] = { 0, 0, -1, 1};

int bfs(int x, int y)
{
	queue<pair<int,int>> queue;
	//현재 좌표를 집어 넣음
	queue.push({x,y});

	//queue 에 데이터가 없을 때 까지 반복
	while(!queue.empty())
	{
		//현재 좌표를 뺀다.
		int x = queue.front().first;
		int y = queue.front().second;
		queue.pop();

		//현재 좌표에서 상하좌우 4방향으로 위치 확인
		for(int i = 0; i < 4; i++)
		{
			// 현재 좌표에서 상하좌우 저장 변수 
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 미로 범위를 넘길 경우 무시
			if(nx < 0 || nx >= n || ny < 0 || ny >= m)
				continue;

			// 괴물이 있으면 (0) 무시
			if(miro[nx][ny] == 0)
				continue;

			// 처음 가는 길일 경우 거리 기록 (+1)
			if(miro[nx][ny] == 1)
			{
				miro[nx][ny] = miro[x][y] + 1;

				// 해당 좌표에 데이터 넣기
				queue.push({nx,ny});
			}
		} 
		
	}
	//최단 거리 반환
	return miro[n-1][m-1];
}

int main()
{
	cin >> n >> m;

	// 괴물이 있는 부분 0, 없는 부분 1
	for(int i = 0; i < n; i++)
	{
		for(int j = 0; j < m; j++)
		{
			cin >> miro[i][j];
		}
	}

	cout << bfs(0,0) << '\n';
}