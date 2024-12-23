#include <iostream>
using namespace std;

// dp[계단수][마지막 자리 수]
long long dp[101][10];

int main(void) {

    int n=0;
    long long result=0;
    cin >> n;

    //n=1 일 때는 0빼고 모두 1로 초기화
    for(int i=1; i<=9; i++){
        
        dp[1][i] = 1;

    }

    for(int i=2; i<=n; i++){
        //마지막 오는 숫자가 0인 n자리 계단 수를 만들기 위해서는 n-1번쨰 계단 수의 마지막 수가 1로 끝나야한다. 
        dp[i][0] = dp[i-1][1] % 1000000000;
        
        //마지막 오는 숫자가 1~9인 n자리 계단 수를 만들기 위해서는 n-1번째 계단 수의 마지막 수가 로 끝나야한다.
        for(int j=1; j<=8; j++){
            dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1] % 1000000000;
        }
        //마지막 오는 숫자가 9인 n자리 계단 수를 만들기 위해서는 n-1번째 계단 수의 마지막 수의 앞뒤 수 로 끝나야한다.
        dp[i][9] = dp[i-1][8] % 1000000000;
    }

    for(int i = 0; i <=9; i++)
    {
        result += dp[n][i];
    }
    
    cout << result%1000000000 << '\n';

}