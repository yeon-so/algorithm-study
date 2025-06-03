#include <iostream>
using namespace std;

int main()
{
  long long N;
  int i = 2;

  cin >> N;

  while(N >= i){

    if(N%i == 0)
    {
      N /= i;
      cout << i << '\n';
    }
    else
    {
      i++;
    }

  }

}