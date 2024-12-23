#include <iostream>
#include <algorithm>

using namespace std;

int dp[2][100001];
int arr[2][100001];

int main(void) {

    int t = 0;
    int n = 0;

    cin >> t;

    for(int i = 0; i<t; i++)
    {
        cin >> n;

        for(int j = 0; j < 2; j++)
        {
            for(int k = 1; k <= n; k++)
            {
                cin >> arr[j][k];
            }
        }

        dp[0][0] = 0;
        dp[1][0] = 0;

        for(int j = 1; j<=n; j++)
        {
            if(j == 1)
            {   
                dp[0][j] = arr[0][1];
                dp[1][j] = arr[1][1];
                continue;
            }

            //DP[i][N] = i행 N번째 스티커를 찢을 때, 가장 최대값이 되는 경우의 점수
            dp[0][j] = max(dp[1][j-1], dp[1][j-2]) + arr[0][j];
            dp[1][j] = max(dp[0][j-1], dp[0][j-2]) + arr[1][j];
        }

        cout << max(dp[0][n], dp[1][n]) << '\n';

    }

}