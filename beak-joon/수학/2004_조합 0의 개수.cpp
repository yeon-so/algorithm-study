#include<iostream>
#include<math.h>
using namespace std;

/*
  nCm = n! / m!(n-m)!
  
  예를 들어 5C2 = 5! / 3! * 2! =  120 / 12 = 10
  뒤에 0이 발생하는 경우는 2와 5가 만나는 경우이다.
   -> 5 * 2 = 10 이니까

  따라서
  1) 분자를 소인수분해하여 2의 개수와 5의 개수를 찾는다. 
  2) 분모를 소인수분해하여 2의 개수와 5의 개수를 찾는다.
  3) 분자의 2의 개수에서 분모의 2의 개수를 뺀다.
  4) 분자의 5의 개수에서 분모의 5의 개수를 뺸다.
  5) 남은 2의 개수와 남은 5의 개수중 작은 값을 출력한다.

  2의 개수 구하는 알고리즘
  1) 2의 개수를 구할 대상을 N 2의 개수를 M
  2) M 에 N/2 값을 더한다.
  3) M 에 N/2*2 더한다.
  ...
  4) M 에 N/ (2의 배수중 N보다 작은 숫자)를 더한다.
  5도 2랑 동일

  O(log N) 시간 복잡도
*/

long long func(long long x, int num)
{
  int result = 0;

  for(long long i = num; i <= x; i*=num)
  {
    result += x/i;
  }

  return result;
};

int main()
{
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  long long n, m;
  cin >> n >> m;

  long long two_cnt = func(n,2) - func(m,2) - func(n-m,2) ;
  long long five_cnt = func(n,5) - func(m,5) - func(n-m,5) ;

  cout << min(two_cnt,five_cnt) << '\n';

}
