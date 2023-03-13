#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main(void) {
    
    int n;
    cin >> n;

    int arr[n];
    vector<int> dp(n);

    for(int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    for(int i = n-1; i >= 0; i--)
    {
        //최소 길이 1로 초기화
        dp[i] = 1;
        for(int j = n-1; j >= 0; j--)
        {
            if(arr[i] > arr[j])
            {
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }
    }

    cout << *max_element(dp.begin(), dp.end()) << '\n';

}