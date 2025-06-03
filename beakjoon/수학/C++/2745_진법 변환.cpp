#include<iostream>
#include<string>
#include<cmath>
using namespace std;

int main()
{
  string N;
  int B;
  int result = 0;

  cin >> N;
  cin >> B;

  int count = N.length() -1;

  for(int i = 0; i < N.length(); i++)
  {
    int tmp = N[i];
    if(tmp >= 'A' && tmp <= 'Z')
    {
      tmp = tmp + 10 - 'A';
    }
    else
    {
      tmp = tmp - '0';
    }
    // pow(B,count) => B^count
    result += tmp * pow(B, count);
    //제곱수 lengh()-1 ~ 0 까지
    count--;
  }
  cout << result << '\n';

}