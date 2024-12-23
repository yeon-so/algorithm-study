#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main(void)
{
    int n; 
    cin >> n;

    //긴증가
    int dp1[n] = {0,};
    //긴감소
    int dp2[n] = {0,};

    int arr[n] = {0,};

    for(int i = 0; i < n; i++)
    {
        cin >> arr[i]; 
    }

    // 왼 -> 오 
    for(int i = 0; i < n; i++)
    {
        //최소 길이 1로 초기화
        dp1[i] = 1;
        for(int j = 0; j < n; j++)
        {
            //증가하는 부분 수열 구하기
            if(arr[i] > arr[j])
            {   
               dp1[i] = max(dp1[i], dp1[j] + 1);
            }

        }
    }

    // 오 -> 왼 
    for(int i = n-1; i >= 0; i--)
    {
        //최소 길이 1로 초기화
        dp2[i] = 1;
        for(int j = n-1; j >= 0; j--)
        {
            //감소하는 부분 수열 구하기
            if(arr[i] > arr[j])
            {
                dp2[i] = max(dp2[i], dp2[j] + 1);
            }
        }
    }
    
    int result = dp1[0] + dp2[0] - 1;

    for (int i = 0; i < n; i++)
    {
        if (result < dp1[i] + dp2[i] - 1)
            result = dp1[i] + dp2[i] - 1;
    }
    cout << result << '\n';
}