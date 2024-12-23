#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

int main(void)
{
    int n;

    cin >> n;

    vector<int> dp(n);
    vector<int> arr(n);

    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }


    for(int i = 0; i < n; i++){

        // 나올 수 있는 가장 최소값
        dp[i] = arr[i];

        for(int j = 0; j < i; j++){
            if(arr[i] > arr[j])
            {
                dp[i] = max(dp[i], dp[j] + arr[i]);
            }
        }

    }

    cout << *max_element(dp.begin(), dp.end()) << '\n';

}