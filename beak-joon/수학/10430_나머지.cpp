#include <iostream>

using namespace std;

int main()
{
  int a;
  int b;
  int c;

  cin >> a >> b >> c;

  int result1 = (a+b)%c;
  int result2 = ((a%c) + (b%c))%c;
  int result3 = (a*b)%c;
  int result4 = ((a%c) * (b%c))%c;

  cout << result1 << '\n';
  cout << result2 << '\n';
  cout << result3 << '\n';
  cout << result4 << '\n';
}