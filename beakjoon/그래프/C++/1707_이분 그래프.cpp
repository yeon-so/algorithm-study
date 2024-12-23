#include <iostream>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

#define RED 1
#define BLUE 2

// K: 테스트 케이스 갯수, V: 정점의 갯수, E: 간선의 갯수
int K, V, E;

// graph
vector<int> graph[20001];
// 방문여부
int visited[20001];

void bfs(int start)
{
	queue<int> q;
	q.push(start);

	//현재 노드를 방문 처리 ( 기본 빨강 )
	if(visited[start] == 0)
		visited[start] = RED;

	while (!q.empty())
	{
		// 큐에서 하나의 원소를 뽑아 출력
		int cur = q.front();
		q.pop();

		for(int i = 0; i < graph[cur].size(); i++)
		{
			int next = graph[cur][i];
			if(visited[next] == 0)
			{
				if(visited[cur] == RED)
					visited[next] = BLUE;
				else
					visited[next] = RED;
				q.push(next);
			}
		}
	}
	
}

void dfs(int start)
{
	//현재 노드를 방문 처리 ( 기본 빨강 )
	if(visited[start] == 0)
		visited[start] = RED;

	for(int i = 0; i < graph[start].size(); i++)
	{
		int next = graph[start][i];
		if(visited[next] == 0)
		{
			if(visited[start] == RED)
				visited[next] = BLUE;
			else
				visited[next] = RED;
			dfs(next);
		}
	}
}

bool isBipartiteGraph()
{
	//접점 갯수 만큼 반복
	for(int i = 1; i <= V; i++ )
	{
		for(int j = 0; j < graph[i].size(); j++)
		{
			int next = graph[i][j];

			if(visited[i] == visited[next])
			{
				return 0;
			}
		}

	}
	return 1;
}

int main()
{
	cin >> K;

	// 테스트 케이스 만큼 반복
	for(int i = 0; i < K; i++)
	{
		cin >> V >> E;
		//간선 입력
		for(int j = 0; j < E; j++)
		{
			int x, y;
			cin >> x >> y;
			graph[x].push_back(y);
			graph[y].push_back(x);
			
		}

		// 해당 그래프 탐색
		for(int i = 1; i <= V; i++)
		{
			if(visited[i] == 0)
			{
				//bfs(i);
				dfs(i);
			}
		}

		// 해당 그래프가 이분 그래프인지 판단
		if(isBipartiteGraph()){
			cout << "YES" << '\n';
		}
		else {
			cout << "NO" << '\n';
		}

		//다음 그래프를 위해 메모리 초기화
		for (int i = 0; i <= V; i++) {
            graph[i].clear();
        }
		memset(visited, false, sizeof(visited));

	}
}