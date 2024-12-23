#include<iostream>
#include<queue>
#include<vector>

using namespace std;

// 인접리스트
vector<int> vec[1001];
// 방문기록
int visited[1001];
// N 정점의 개수, M 간선의 개수 
int N, M;

void dfs(int start)
{
	// 현재 노드를 방문 처리
	visited[start] = 1;

	// 현재 노드와 연결된 다른 노드를 재귀적으로 방문
	// 현재 노드가에 해당하는 백터 크기만큼 돌아야한다.
	// 배열일 경우 N 만큼 돌아도 된다.
	for( int i = 0; i < vec[start].size(); i++)
	{
		int next = vec[start][i];
		if(visited[next] == 0)
		{
			dfs(next);
		}
	}
}

void bfs(int start)
{
	queue<int> q;
	q.push(start);
	// 현재 노드를 방문 처리
	visited[start] = 1;

	while(!q.empty())
	{
		// 큐에서 하나의 원소를 뽑아 출력
		int cur = q.front();
		q.pop();

		for(int i = 0; i < vec[cur].size(); i++)
		{
			int next = vec[cur][i];
			if(visited[next] == 0)
			{
				visited[next] = 1;
				q.push(next);
			}
		} 
	}
}

int main()
{

	cin >> N >> M;

	for(int i = 0; i < M; i++)
	{
		int u, v;
		cin >> u >> v;

		vec[u].push_back(v);
		vec[v].push_back(u);
	}

	//연결요소 갯수
	int cnt = 0;
	for(int i = 1; i <= N; i++)
	{
		if (visited[i] == 0)
		{
			cnt++;
			bfs(i);
			//dfs(i);
		}
	}

	cout << cnt << '\n';
    
}