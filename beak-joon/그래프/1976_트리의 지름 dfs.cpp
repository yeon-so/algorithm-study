#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

vector<pair<int,int>> v[10001];
int visited[10001] = {0,};
int maxDist = 0;
int maxNode = 0;

void dfs(int i, int dist)
{
	// 이미 방문했다면 탈출
	if(visited[i] != 0)	return;
	// 간선 거리 및 먼 노드 체크
	if(maxDist < dist)
	{
		maxDist = dist;
		maxNode = i;
	}

	// 방문 처리
	visited[i] = 1;

	// 다음 노드 탐색
	for(int j = 0 ; j < v[i].size(); j++)
	{
		// 다음 노드 정보
		int ni = v[i][j].first;
		int nd = v[i][j].second;

		dfs(ni , dist + nd);
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
	dfs(1,0);

	// 데이터 초기화
	maxDist = 0;
	memset(visited, 0, sizeof(visited));
	
	// 2. 먼 정점에서 먼 정점까지 거리가 지름
	dfs(maxNode, 0);

	cout << maxDist;
}