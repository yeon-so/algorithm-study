#include<iostream>

using namespace std;

int dp[31];

int main(void){

    int n;
    cin >> n;

    dp[0] = 1;
    dp[1] = 0;
    dp[2] = 3;

    for(int i = 4; i <= n; i += 2)
    {
        dp[i] = dp[i-2] * dp[2];
        cout << i-2 << " : " << dp[i] << endl;
        for(int j = i - 4; j >= 0; j -= 2)
        {
            dp[i] += dp[j] * 2;
            cout << j << " " << dp[j] << endl;
        }
    }

    cout << dp[n] << '\n';

}