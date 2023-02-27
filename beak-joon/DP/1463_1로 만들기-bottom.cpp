#include <iostream>
#include <algorithm>

using namespace std;

//Bottom-up
/*
점화식
dp[n] = dp[n/3] + 1;
dp[n] = dp[n/2] + 1;
dp[n] = dp[n-1] + 1;
*/

// dp[n]을 1로 만드는데 필요한 연산 횟수
int dp[1000000];

int main(void){

    //입력 값이 1이면 연산 횟수는 1
    dp[1] = 0;

    int n = 0;
    cin >> n; 

    //입력 값이 2부터 n까지의 최소 연산 횟수 구하기
    for(int i = 2; i <= n; i++){
        dp[i] = dp[i-1] + 1;
        if(i % 3 == 0)
            dp[i] = min(dp[i] , dp[i/3] + 1);
        if(i % 2 == 0) 
            dp[i] = min(dp[i] , dp[i/2] + 1);
    }

    cout << dp[n] << '\n';

}