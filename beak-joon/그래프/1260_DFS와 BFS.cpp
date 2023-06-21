#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int N, M, V; //정점(노드)개수, 간선개수, 시작정점
int graph[1001][1001]; //인접 행렬 그래프
bool visited[1001]; //정점 방문 여부
queue<int> q;

// DFS 함수 정의
void dfs(int v)
{
  // 현재 노드를 방문 처리
  visited[v] = true;
  cout << v << " ";

  // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
  for(int i = 1; i <= N; i++) {
    int next = graph[v][i]; 
    // 현재 노드와 연결되어있고 방문하지 않았으면 재귀적 방문
    if (!visited[i] && next == 1) 
      dfs(i);
  }
}

// BFS 함수 정의
void bfs(int v)
{
  q.push(v);
  // 현재 노드를 방문 처리
  visited[v] = true;
  cout << v << " ";

  // 큐가 빌 때까지 반복
  while(!q.empty()){
    // 큐에서 하나의 원소를 뽑아 출력
    v = q.front();
    q.pop();

    // 해당 원소와 연결되었으며 아직 방문하지 않은 원소들을큐에 삽입
    for(int i = 1; i <= N; i++)
    {
      int next = graph[v][i];
      if(!visited[i] && next == 1) {
        q.push(i);
        visited[i] = true;
        cout << i << " ";
      }
    }
  }
}

int main()
{
  cin >> N >> M >> V;

  for(int i = 0; i < M; i++)
  {
    int x, y;
    cin >> x >> y;
    // 양방향 간선 처리
    graph[x][y] = 1;
    graph[y][x] = 1;
  }

  for (int i = 1; i <= N; i++) {
    visited[i] = 0;
  }
  dfs(V); 
  cout << '\n';

  for (int i = 1; i <= N; i++) {
    visited[i] = 0;
  }
  bfs(V);
  cout << '\n';
}

/* 인접 리스트 이용
#include<iostream>
#include<queue>
#include<vector>
#include<algorithm>

using namespace std; 

vector<int> map[1001];
bool visited[1001];

//깊이 우선 탐색
void dfs(int v)
{
	//해당 정점 방문 처리 후 출력
	visited[v] = true;
	cont << v << " ";

	for(int i = 0; i < map[v].size(); i++){
		int next = map[v][i];
		// next 정점을 방문한 적없으면 dfs를 재귀호출한다.
		if(!visited[next])
			bfs(next);
	}
}

//너비 우선 탐색
void bfs(int v)
{
	queue<int> q;
	// 해당 정점을 queue에 저장하고 방문 처리
	q.push(v);
	visited = true;
	// queue가 비워있지 않는 동안
	while(!q.empty())
  {
		// queue 큐에서 현재 정점을 꺼내 출력 후 제거 
		int cur = q.top();
		q.pop();
		cout << cur  << " ";
		// 현재 방문한 정점과 이어져 있는 정점의 개수만큼 반복
		for (int i = 0; i < map[cur].size(); i++) {
			int next = e[cur][i];
			// 만약 next 정점이 방문한 적 없으면 방문 처리 후 queue에 저장
			if (!check[next]) {
				check[next] = true;
				q.push(next);
			}
		}  
	
}

int main()
{
  // 정점, 간선, 탐색을 시작할 정점의 번호
	int N, M, V;
	cin >> N >> M >> V;

	for(int i = 0; i < M; i++)
	{
		int x,y;
		cin >> x >> y;
		map[x].push_back(y);
	  map[y].push_back(x);
	}

	// 정점 번호가 작은 것을 먼저 방문해야 해서 오름차순으로 정렬
	for(int i = 0; i <= N; i++)
	{
		sort(map[i].begin(), map[i].end());
	}

	dfs(V);
	cout << '\n';
	for(int i = 0; i <= N; i++)
	{
		visit[i] = false;
	}
	bfs(V);
	cout << '\n';
}
*/