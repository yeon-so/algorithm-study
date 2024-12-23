#include <iostream>
using namespace std;

//k=0 dp[n][0] = 1
//k=1~9 dp[n-1][k] = dp[n][k-1] + dp[n-1][k]

const int MOD = 10007;
int dp[1001][10] = {0,};

int main(void)
{
    int n = 0;
    int result = 0;
    cin >> n;

    //n==1 , dp[1][k] 는 1로 초기화
    for(int i = 0; i <= 9; i++)
    {
        dp[1][i] = 1;
    }

    for(int i = 2; i <= n; i++)
    {
        for(int j = 0; j <=9; j++)
        {
            if(j == 0) {
                dp[i][0] = 1;
                continue;
            }

            dp[i][j] = dp[i][j-1] + dp[i-1][j] % MOD;
        }
        
        
    }

    for(int i = 0; i <= 9; i++)
    {
        result += dp[n][i];
    }

    cout << result % MOD << '\n';
    
}