#include<iostream>

using namespace std;

// 점화식
// dp[n] = dp[n-1] + dp[n-2]

int d[1001] = { 0, }; // 0으로 자동 초기화, 전역이라 따로 초기화 안해도 0으로 초기화되긴 함

int dp(int num){

    // 2 x 1 일 때 방법 수 : 1
    if(num == 1) return 1;
    // 2 x 2 일 때 방법 수 : 2
    if(num == 2) return 2;

    //동적 저장
    if(d[num] != 0) return d[num];

    //수가 크기 때문에 10007로 나눈 값을 요구
    return d[num] = (dp(num-2) + dp(num-1)) % 10007;

}

int main(void){

    int n=0; 
    cin >> n;

    cout << dp(n) << '\n';

}