#include<iostream>
#include<algorithm>

using namespace std;

int main(void)
{
    int n = 0;
    cin >> n ;
    
    //0으로 초기화
    int arr[n] = {0,};
    int dp[n] = {0,};

    for(int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    dp[0] = arr[0];
    int result = arr[0];

    for(int i = 1; i < n; i++)
    {
        dp[i] = max(dp[i-1] + arr[i], arr[i]);
        result = max(dp[i], result);
    }

    cout << result << '\n';
}