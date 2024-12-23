#include <iostream>
#include <vector>
using namespace std;

//소수 : 1과 자기자신으로만 나눠질 수 있는 수
//1978과 동일한 방법으로 풀면 시간초과
// 따라서 에라토스테네스의 체 방법 사용
/*
  에라토스테네스의 체 방법
   - n개의 숫자를 차례대로 쓴다.
   - 1은 소수가 아니무로 지운다.
   - 2는 두고 2의 배수를 모두 지운다.
   - 남은 숫자 중 가장 작은 수인 3은 두고 3의 배수는 모두 지운다.
   - 그렇게 n의 배수까지 지운다.
   - 남은 수는 소수, 지운 수는 함성수, 1은 1 
*/

int main(){
  int m, n;
  
  cin >>  m >> n;

  // 0~n 까지 0으로 초기화 
  // 0 인 값은 합성수
  vector<int> v(n+1, 0);

  for(int i = 2; i <= n; i++)
  {
    v[i] = i;
  }

  for(int i = 2; i <= n; i++)
  { 
      if(v[i] == 0) continue;
      // 2~ n의 배수면 해당 수는 합성수이므로 0으로 만든다.
      for(int j = 2*i; j <= n; j +=i)
      {
        if(v[j] == 0) continue;
        else v[j] = 0;
      }
  }

  
  for(int i = m; i <= n; i++)
  {
      if(v[i] != 0) cout << v[i] << '\n';
  }

}