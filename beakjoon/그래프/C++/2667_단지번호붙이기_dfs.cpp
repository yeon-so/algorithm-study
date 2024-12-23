#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int graph[25][25] = {0,};
int visited[25][25] = {0,};
vector<int> result;

//방향
int dx[] = {-1,0,1,0};
int dy[] = {0,1,0,-1};

//총 단지수
int N;

// 집 갯수
int cnt;

void dfs(int x, int y)
{
	// 해당 지점의 상하좌우 체크
	for(int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

		// 그래프 범위 밖이면 건너뜀
		if( nx < 0 || ny < 0 || nx >= N || ny >= N )
			continue;

			// 방문을 아직 안했고 집이 지점에 있을 시
			if(visited[nx][ny] == 0 && graph[nx][ny] == 1)
			{
				// 방문 처리
				visited[nx][ny] = 1;
				// 집 갯수 카운트
				cnt +=1;
				// 재귀 호출
				dfs(nx,ny);
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
				visited[i][j] = 1;
				cnt += 1;
				dfs(i,j);
				result.push_back(cnt);
				// 카운트 초기화
				cnt = 0;
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