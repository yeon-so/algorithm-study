/*
	트리의 지름
	- 임의의 두 점 사이의 거리 중 가장 긴 것

	찾는 법
	1. 임의의 정점 X에서 가장 먼 정점 y를 찾는다.
	2. 정점 y에서 가장 먼 정점 z 과의 거리가 트리의 지름이다.
*/

#include<iostream>
#include<vector>
#include<cstring> // memset

using namespace std;

// pair<정점,거리> 
vector<pair<int,int>> v[100001];
// 방문 여부 
int visited[100001] = {0,};
// 트리의 지름 
int maxDist;
// 가장 먼 정점
int maxNode;

// 긴 정점 및 지름 찾기
void dfs(int node, int dist)
{
	// 이미 방문했다면 함수를 빠져나간다.
	if(visited[node] != 0){
		return;
	}
	// 두 점간의 가장 긴 거리 및 노드 구하기
	// 현재 길이보다 긴 거리 변수가 작으면 현재 길이 대입
	if(maxDist < dist)
	{
		maxDist = dist;
		maxNode = node;
	}
	// 현재 노드 방문 처리
	visited[node] = 1;

	// 현재 노드에 연결된 다음 노드로 재귀하여 먼 정점 구하기
	for(int i = 0; i < v[node].size(); i++)
	{
		// 다음 노드, 거리
		int dn = v[node][i].first;
		int dd = v[node][i].second;
		// 재귀 ( 현재 거리 + 다음 노드 거리)
		dfs(dn, dist + dd);
	}
}

int main()
{
	//입력
	int V;
	cin >> V;
	for(int i = 0; i < V; i++)
	{
		int a, b, c;
		cin >> a >> b;

		while(b != -1){
			cin >> c;
			v[a].push_back({b,c});
			v[b].push_back({a,c});
			cin >> b;
		}
	}

	// 1. 임의의 정점 X에서 가장 먼 정점 y를 찾는다.
	dfs(1,0); // 임의의 정점 1 , 거리 0

	// 2번 하기전 데이터 초기화
	maxDist = 0;
	memset(visited, 0, sizeof(visited));

	// 2.정점 y에서 가장 먼 정점 z 과의 거리가 트리의 지름이다.
	dfs(maxNode,0);

	cout << maxDist << '\n';
	
}



