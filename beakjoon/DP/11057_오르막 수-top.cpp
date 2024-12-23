#include <iostream>

using namespace std;

#define MOD 10007;

//  dp[n][k] = dp[n-1][k] + dp[n][k-1]

int dp[1001][10] = { 0, };

int d(int num, int k) {

    // num = 1 일때는 모두 1이라 1 반환
    if( num == 1 ) 
    {   
        return 1;
    }    
    // num = 0 일때는 모두 1이라 1 반환
    if( k == 0 ) return 1;

    //동적 저장
    if( dp[num][k] != 0) return dp[num][k]% MOD;

    return dp[num][k] = d(num-1, k) + d(num, k-1) ;

}

int main(void){

    int n = 0;
    int result = 0;
    cin >> n;

    for(int i = 0; i <= 9; i++)
    {
        result += d(n,i);
    }

    result %= MOD;

    cout << result << '\n';

}
