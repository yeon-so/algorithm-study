#include <iostream>

using namespace std;

// 점화식
// dp[n] = dp[n-1] + dp[n-2]*2;

int dp[1001];

int d(int num) {
    
    if(num == 1) return 1;
    if(num == 2) return 3;

    //동적 저장
    if(dp[num] != 0) return dp[num];

    return dp[num] = (d(num-1) + d(num-2)*2)% 10007;

}

int main(void) {

    int n;
    cin >> n;
    
    cout << d(n) << '\n';

}