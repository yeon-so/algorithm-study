#include<iostream>
#include<queue>
#include<vector>

using namespace std;

/*
 1. 루트 노드(1) 을 큐에 삽입
 2. 큐에서 하나씩 요소를 꺼내어 꺼낸 노드의 자식 노드 검사
 2-1. 자식 노드 검사 세부 사항
	자식 노드를 아직 방문하지 않았다면, 
		result[next] = cur - 부모 노드 저장
		해당 자식 노드 방문 처리
		해당 자식 노드 큐에 삽입
 3. 큐가 비워질 때까지 2 반복	
*/

vector<int> graph[100001];
// 해당 노드의 부모
int result[100001];
// 방문 여부
int visited[100001];

void bfs(int x)
{
	queue<int> q;
	// 해당 노드 큐에 삽입
	q.push(x);

	// 큐가 비워질 때까지 반복
	while (!q.empty())
	{
		// 큐에서 하나의 원소를 뽑고 큐에서 제거
		int cur = q.front();
		q.pop();

		// 현재 노드와 연결된 다음 노드의 수만큼 반복
		for(int i = 0; i < graph[cur].size(); i++)
		{
			int next = graph[cur][i];
			// 다음 노드를 방문하지 않았을 경우
			if(visited[next] == 0)
			{
				// 다음 노드의 부모를 현재 노드로 설정
				result[next] = cur;
				// 다음 노드 방문 처리
				visited[next] = 1;
				// 다음 노드 큐에 삽입
				q.push(next);
			}
		}
	}
	
}

int main()
{
	int node;

	cin >> node;

	//트리 입력
	for(int i = 0; i < node-1; i++)
	{
		int one, two;
		cin >> one >> two;
		
		// 간선 연결
		graph[one].push_back(two);
		graph[two].push_back(one);
	}

	// 각 노드의 부모 노드 구하기 (깊이 우선)
	bfs(1);

	// 2부터 각 노드의 부모 노드 출력
	for(int i = 2; i <= node; i++)
	{
		cout << result[i] << '\n';
	}
}
