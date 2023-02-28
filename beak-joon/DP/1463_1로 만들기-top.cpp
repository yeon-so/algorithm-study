#include <iostream>
#include <algorithm>

using namespace std;

//top-down

/*
점화식
dp[n] = dp[n/3] + 1;
dp[n] = dp[n/2] + 1;
dp[n] = dp[n-1] + 1;
*/

// dp[n]을 1로 만드는데 필요한 연산 횟수
int dp[1000000];

int dp_f(int num){
    
    if(num==1) return 0;
    //memorization
    if(dp[num] > 0) return dp[num];

    dp[num] = dp_f(num-1) + 1;

    if(num % 3 == 0){
        dp[num] =  min(dp[num], dp_f(num/3) + 1);
    }

    if(num % 2 == 0){
        dp[num] = min(dp[num], dp_f(num/2) + 1);
    }

    return dp[num];
}

int main(void){

    int n = 0;
    cin >> n; 

    cout << dp_f(n) << '\n';

}