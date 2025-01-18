#include <iostream>
#include <string>
using namespace std;

int dp[5001];
int arr[5001];
string str;

int main(void)
{
    cin >> str;

    for(int i = 1; i <= str.size(); i++)
    {
        arr[i] = str[i-1] - '0';
    }

    dp[0] = 1;
    
    if(str.size() == 1 && arr[0] == '0')
    {
       cout << 0 << '\n';
    }

    for(int i = 1; i <= str.size(); i++)
    {
        //첫번째 방법 두 숫자를 각각 알파벳으로 대입
        // 1 ~ 9 사이의 값만 첫번째 방법 사용 가능
        if( arr[i] >= 1 && arr[i] <= 9)
        {
            dp[i] = (dp[i-1] + dp[i]) % 1000000;
        }

        //첫번째 숫자라면 2번 방법은 건너뛴다.
        if(i == 1) continue;

        //두번째 방법 두 숫자를 세트로 뭉친다.
        // 10 ~ 25 사이의 값만 첫번째 방법 사용 가능
        int temp = arr[i-1]*10 + arr[i];
        if( temp >= 10 && temp <= 26)
        {
            dp[i] = (dp[i-2] + dp[i]) % 1000000;
        }
        
    }

    cout << dp[str.size()] << '\n';
}