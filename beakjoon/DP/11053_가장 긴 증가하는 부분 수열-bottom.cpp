#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

 int main(void)
 {
    
    int n;

    cin >> n;

    // dp[i] i+1번째 원소로 끝나는 배열의 가징 긴 증가하는 길이
    vector<int> dp(n);

    // n 길이인 수열
    // 최소값 1로 모두 초기화
    int arr[n] = { 1,};

    for(int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    for(int i = 0; i < n; i++)
    {
        // 부분 수열의 길이는 최소 1 이상임으로 1로 초기화
        dp[i] = 1;
        
        for(int j = 0; j < i; j++)
        {
            // 마지막 원소(i) 와 그 전 원소들을 비교
            // 만일 마지막 원소의 값이 더 크다면 적어도 마지막 요소가 j 일때 최대 길이 + 1 만큼은 크다.
            if(arr[i] > arr[j])
            {
                //다만 i 값이 j 원소'들'보다 크다면 무조건 조건에 맞는 j 최대 길이 +1 일이 됨으로 가장 긴 길이를 구하기 위해서
                //이전 j-1 과 비교하여 도출한 최대 길이 (최소 1인) dp[i] 와 비교하여 더 큰 값을 넣는다.
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }
    }

    // 최종 적으로 dp 길이중에 가장 큰 값을 출력 (dp를 vector 정의한 이유)
    cout << *max_element(dp.begin(), dp.end()) << '\n';

 }