#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

/*
  10진법 - N진법으로 바꾸기
*/

string bTransform(long long n, int b)
{
  string result;
  while(n != 0)
  {
    int tmp = n % b;

    if(tmp > 9)
    {
      result += (char)(tmp - 10 + 'A');
    }
    else
    {
      result += (char)(tmp + '0');
    }
    n /= b;
  }

  return result;
}

int main()
{
  int N;
  int B;

  cin >> N;
  cin >> B;

  string result = bTransform(N,B);

  reverse(result.begin(),result.end());

  cout << result << '\n';
}