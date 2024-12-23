#include <iostream>

using namespace std;

// dp[n] = dp[n-1] + dp[n-2]

long long dp[91] = { 0, };

int main(void){

    int n = 0;
    long long result = 0;
    cin >> n;

    dp[1] = 1;
    dp[2] = 1;

    for(int i=3; i<=n; i++)
    {
        dp[i] = dp[i-1] + dp[i-2];
    }

    result = dp[n];

    cout << result << '\n';

}