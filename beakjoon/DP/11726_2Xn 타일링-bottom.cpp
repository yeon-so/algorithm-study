#include<iostream>

using namespace std;

// 점화식
// dp[n] = dp[n-1] + dp[n-2]

int d[1001] = { 0, }; // 0으로 자동 초기화, 전역이라 따로 초기화 안해도 0으로 초기화되긴 함

int main(void){

    int n=0; 

    d[1] = 1;
    d[2] = 2;

    cin >> n;

    for(int i = 3; i <= 1000; i++){
        
        d[i] = (d[i-1] + d[i-2]) % 10007;

    }

    cout << d[n] << '\n';

}