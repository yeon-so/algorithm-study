#include <iostream>

using namespace std;

// n개 숫자, k 마지막 수
// dp[n][k] = dp[n-1][k-1] + dp[n-1][k+1]
// dp[n][0] = dp[n-1][1]
// dp[n][9] = dp[n-1][8]

long long dp[101][10];

long long d(int num, int index){

    if(num == 1)
    {
        if(index == 0) return 0;
        return 1;
    }
    
    if(dp[num][index] != 0) return dp[num][index];

    if(index == 0 ) return dp[num][0] = d(num-1,1) % 1000000000;;
    if(index == 9 ) return dp[num][9] = d(num-1,8) % 1000000000;;

    return dp[num][index] = d(num-1,index-1) + d(num-1,index+1) % 1000000000;

}


int main(void){

    int n;
    long long result = 0;
    cin >> n;

    //n=1, 0빼고 1로 초기화
    for(int i = 1; i <= 9; i++){
        dp[1][i] = 1;
    }

    for(int i= 0; i <= 9; i++){
            
            result += d(n,i);

    }
    cout << result % 1000000000 << '\n';
}