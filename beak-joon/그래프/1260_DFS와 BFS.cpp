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