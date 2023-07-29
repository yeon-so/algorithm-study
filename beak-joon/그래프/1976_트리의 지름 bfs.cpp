#include <iostream>
#include <vector>
#include <cstring>
#include <queue>

using namespace std;

vector<pair<int,int>> v[10001];
int visited[10001] = {0,};
int maxDist = 0;
int maxNode = 0;

void bfs(int i)
{
	queue<pair<int,int>> q;
	// 현재 정점 , 가중치 큐에 삽입
	q.push({i,0});
	// 방문 처리
	visited[i] = 1;

	// 큐가 비워질 때까지 반복
	while (!q.empty())
	{
		// 큐의 현재 원소 꺼내기 
		int ci = q.front().first;
		int cd = q.front().second;
		q.pop();
		// 최대 거리 및 가장 먼 정점 갱신
		if(maxDist < cd)
		{
			maxDist = cd;
			maxNode = ci;
		}

		for(int j = 0; j < v[ci].size(); j++)
		{
			// 다음 노드 정보
			int ni = v[ci][j].first;
			int nx = v[ci][j].second;

			// 다음 노드의 방문을 하지 않았다면
			if(visited[ni] == 0)
			{
				// 방문 처리
				visited[ni] = 1;
				// 큐에 다음 정점 큐에 삽입
				q.push({ni, cd + nx});
			}


		}
	}
	
}

int main()
{
	//노드의 개수
	int n;

	cin >> n;

	for(int i = 1; i < n; i++)
	{
		int rn, dn, d;
		cin >> rn >> dn >> d;
		// 간선 연결
		v[rn].push_back({dn,d});
		v[dn].push_back({rn,d});
	}

	// 1. 임의의 정점에서 가장 먼 정점 찾기
	bfs(1);

	// 데이터 초기화
	maxDist = 0;
	memset(visited, 0, sizeof(visited));
	
	// 2. 먼 정점에서 먼 정점까지 거리가 지름
	bfs(maxNode);

	cout << maxDist;
}