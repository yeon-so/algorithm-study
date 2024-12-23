#include <iostream>
#include <queue>
#include <vector>

using namespace std;

vector<int> graph[20001];
bool visited[2001];

//테스트 케이스
int T;

//깊이 우선 탐색
void dfs(int start)
{
	//해당 정점 방문 처리
	visited[start] = true;

	for(int i = 0; i < graph[start].size(); i++)
	{
		int next = graph[start][i];
		if(!visited[next])
		{
			dfs(next);
		}
	}
}

//너비 우선 탐색
void bfs(int start)
{
	queue<int> q;
	// 해당 정점을 큐에 넣고 방문 처리
	q.push(start);
	visited[start] = true;

	//q에 값이 없을때까지 반복
	while (!q.empty())
	{
		//큐에서 현재 장점을 빼내고 큐에서 제거
		int cur = q.front();
		q.pop();

		//현재 정점과 이어져 있는 정점의 개수만큼 반복
		for(int i = 0; i < graph[cur].size(); i++)
		{
			int next = graph[cur][i];
			if(!visited[next])
			{
				visited[next] = true;
				q.push(next);
			}
			else if(next == start)
			{
				//visited[next] = true;
			}
		}
	}
	
}

int main()
{
	cin >> T;

	while(T--)
	{
		//순열 크기
		int N;
		cin >> N;

		for(int i=1; i<=N; i++)
		{
			//그래프 초기화
			graph[i].clear();
			//배열 초기화
			visited[i]=false;

			//순열
			int X;
			cin >> X;
			//한반향 그래프임으로 한쪽 간선만 
			graph[i].push_back(X);
		}
		//사이클 갯수
		int count = 0;

		for(int i=1; i<=N; i++)
		{
			if(!visited[i])
			{
				count++;
				dfs(i);
                //bfs(i);
			}
		}
		cout << count << '\n';
	}
}