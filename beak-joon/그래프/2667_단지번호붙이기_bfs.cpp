#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <queue>

using namespace std;

int graph[25][25] = {0,};
int visited[25][25] = {0,};
queue<pair<int,int>> q;
vector<int> result;

//방향
int dx[] = {-1,0,1,0};
int dy[] = {0,1,0,-1};

//총 단지수
int N;

// 집 갯수
int cnt;

void bfs(int x, int y)
{
	// 해당 지점 큐에 삽입
	q.push({x,y});
	// 해당 지점 방문 처리
	visited[x][y] = true;
	// 카운트 증가
	cnt++;

	// 큐가 빌때까지 반복
	while(!q.empty()) {
		// 큐 맨 앞 값의 x,y 값 변수 선언
		int a = q.front().first;
		int b = q.front().second;
		// 큐에서 해당 값 삭제
		q.pop();

		// 상하좌우 체크
		for(int i = 0; i < 4; i++) {
			int nx = a + dx[i];
			int ny = b + dy[i];

			//범위 밖이면 탈출
			if( nx < 0 || ny < 0 || nx >= N || ny >= N )
				continue;

			if(visited[nx][ny] ==0 && graph[nx][ny] == 1)
			{
				q.push({nx,ny});
				visited[nx][ny] = true;
				cnt++;
			}
		}	
	}
}

int main()
{

	cin >> N;
	string x;

	for(int i = 0; i < N; i++)
	{
		cin >> x;
		for(int j = 0; j < N; j++)
		{
			graph[i][j] = x[j] - '0'; // j번째 문자를 받아와 정수로 변경해 삽입
		}
		
	}

	for(int i = 0; i < N; i++)
	{
		for(int j = 0; j < N; j++)
		{
			if(visited[i][j] == 0 && graph[i][j] == 1)
			{
				// 카운트 초기화
				cnt = 0;
				bfs(i,j);
				result.push_back(cnt);
			}
		}
	}

	//단지 갯수 출력
	cout << result.size() << '\n';
	sort(result.begin(),result.end());
	for(int i = 0; i < result.size(); i++)
	{
		cout << result[i] << '\n';
	}
}