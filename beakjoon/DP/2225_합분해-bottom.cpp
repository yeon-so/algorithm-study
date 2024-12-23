#include <iostream>

using namespace std;

//dp[k][n] = k개의 값을 더히여 그 합이 n이 나오는 경우의 수
long long dp[201][201];

int main(void)
{
    int n, k;

    cin >> n >> k;

    //K가 1일때는 1개의 값을 이용해 N이 나와야 함으로 N 즉 1개의 경우의 수만 가능하다.
    for(int i =0; i<=n; i++)
    {
        dp[1][i] = 1;
    } 

    for(int i = 1; i <= k; i++){
		for(int j = 0; j <= n; j++){
            for(int l = 0; l <= j; l++)
            {
			    dp[i][j] += dp[i-1][j-l];
                dp[i][j] %= 1000000000;
            }
        }
    }
    cout << dp[k][n] << '\n';

}