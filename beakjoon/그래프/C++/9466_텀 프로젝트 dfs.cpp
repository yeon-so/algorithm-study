#include<iostream>
#include<cstring> // memset

#define MAX 100001

using namespace std;

int N, cnt;

int graph[MAX];
int visited[MAX];
int done[MAX]; // 방문 종료 여부

void dfs(int start)
{
	//해당 노드 방문 처리
	visited[start] = 1;

	//다음 노드
	int next = graph[start];
	//다음 노드에 방문을 안했을 경우 재귀 호출
	if(visited[next] == 0)
	{
		dfs(next);
	}
	//이미 방문은 했으나 방문 종료가 끝나지 않았다면
	else if(done[next] == 0)
	{
		for(int i = next; i != start; i = graph[i])
			cnt++; //팀원 수 더하기
				cnt++; //본인 수도 더하기
	}

	done[start] = 1;
}

int main()
{
	int T;

	cin >> T;

	while(T--)
	{
		cin >> N;

		for(int i = 1; i <= N; i++)
			cin >> graph[i];
		
		cnt = 0;
		// 팀을 이루는 사람들 구하기
		for(int i = 1; i <= N; i++)
		{
			if(visited[i] == 0) 
				dfs(i);
		}

		// 저체 수에서 팀을 이룬 수 빼기
		cout << N - cnt << '\n';

        // 배열 초기화
		memset(visited, 0, sizeof(visited));
		memset(done, 0, sizeof(done));
	}
}