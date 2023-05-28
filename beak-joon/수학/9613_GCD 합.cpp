#include<iostream>
using namespace std;

int gcd(int a, int b)
{
  /*
    int r;
    while(b!=0)
    {
      r = a%b;
      a = b;
      b = r;
    }
    return a;
  */

  return b != 0 ? gcd(b, a%b) : a;
}

int main()
{
  int arr[101] = {0,};
  //테스트 케이스
  int t;
  long long result = 0;

  cin >> t;

  for(int i =0; i<t; i++)
  {
    int n;
    cin >> n;
    
    for(int j=0; j < n; j++)
    {
      cin >> arr[j];
    }

    for(int j=0; j < n; j++)
    {
      for(int k= j+1; k < n; k++)
      {
        result += gcd(arr[j],arr[k]);
      }
    } 
    cout << result << '\n';
    result = 0;
  }
}
