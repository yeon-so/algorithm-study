#include <iostream>
#include <cmath>

#define MAX 3000001

using namespace std;

int A,P;
int visited[MAX];

void dfs(int start)
{	

	//방문이 중복될 경우 종료
	if(visited[start] > 2)
		return;

	//방문 처리
	visited[start]++;

	int next = 0;
	// 해당 숫자의 각 자리의 숫자를 P번 곱한 수들의 합을 더한다.
	while(start)
	{
		next += pow((start%10),P);
		start /= 10;
	}

	dfs(next);

}

int main()
{

	int result = 0; 

	cin >> A >> P;

	dfs(A);

	for(int i = 0; i < MAX; i++)
	{
		if(visited[i] == 1) result++;
	}

	cout << result << '\n';
}