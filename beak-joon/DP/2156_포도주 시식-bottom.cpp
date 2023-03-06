#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

/* 
 dp[1] = wine[1]
 dp[2] = wine[1] + wine[2]
 dp[3] = max(dp[2], dp[1] + wine[3], wine[2] + wine[3])
 dp[4] = max(dp[3], dp[2] + wine[4], dp[1] + wine[3] + wine[4])
 dp[n] = max(dp[n-1], dp[n-2] + wine[n], dp[n-3] + wine[n-1] + wine[n])
*/

//n(1~10000)개의 포도주 중 최대로 마실 수 있는 저장값
int dp[10001] = {0, };
 

int main(void){

    //포도주 잔의 개수
    int n = 0;
    cin >> n;
    
    //포도주 잔마다의 포도주 양
    int wine[n+1] = { 0, };
    
    for(int i = 1; i <= n; i++)
    {
        cin >> wine[i];
    }
    
    //초기값 세팅
    dp[1] = wine[1];
    dp[2] = wine[1] + wine[2];
    dp[3] = max({dp[2], dp[1] + wine[3], wine[2] + wine[3]});

    if(n > 3){
        for(int i = 4; i <=n; i++)
        {
            dp[i] = max({dp[i-1], dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i]});
        }
    }
    
    cout << dp[n] << '\n';
}
 
 