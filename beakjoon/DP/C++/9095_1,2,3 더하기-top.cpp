#include <iostream>

using namespace std;

// 1 일 때 1 (1)
// 2 일 때 1+1 2 (2)
// 3 일 때 1+1+1 1+2 2+1 3 (4)
// 4 일 때 1+3 / 1+1+2 2+2 / 1+1+1+1 1+2+1 2+1+1 3+1 (7)
// 5 일 때 113 23 / 1112 122 32 / 131 1121 221 11111 1211 2111 311 (13)
// 발화식 dp[n] = dp[n-1] + dp[n-2] +  dp[n-3]

// n은 양수고 11보다 작다.
int dp[11];

int d(int num){

    // 1,2,3 일 때
    if( num == 1 ) return 1;
    if( num == 2 ) return 2;
    if( num == 3 ) return 4;

    //동적 저장
    if( dp[num] != 0 ) return dp[num];

    return dp[num] = d(num - 1) + d(num - 2) + d(num - 3);

}

int main(void) {

    //케이스
    int t;
    cin >> t; 

    // n 저장 공간
    int n = 0;

    // 케이스 결과
    for(int i = 0; i < t; i++){
        cin >> n;
        cout << d(n) << '\n';
    }

}

