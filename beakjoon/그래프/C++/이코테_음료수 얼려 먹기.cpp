#include<iostream>

using namespace std;

int n, m;
int map[1001][1001];

bool dfs(int x, int y)
{
	//특정한 지점의 상하좌우를 살펴보고 범위가 아닐 시 false 처리
	if(x <= -1 || x >= n || y <= -1 || y >= m)
	{
		return false;
	}

	// 특정한 지점을 방문하지 않았다면 ( 값이 0 이면)
	if(map[x][y] == 0)
	{
		// 특정한 지점을 방문처리
		map[x][y] = 1;

		// 지점에서 다시 상하좌우의 방문 여부를 진행
		dfs(x - 1, y);
		dfs(x + 1, y);
		dfs(x, y - 1);
		dfs(x, y + 1);

		return true;
	}
	
	return false;
}

int main()
{

	cin >> n >> m;

	for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> map[i][j];
        }
    }

	// 아이스크림 갯수
	int result = 0;
	for(int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
            if(dfs(i,j))
				result += 1;
        }
	}

	cout << result << '\n';

}