#include<iostream>
#include<algorithm>
#include<string.h>

using namespace std;

int main()
{
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  string str;
  int n;
  cin >> n;

  //n이 0이면
  if(!n) str = "0";
  else
  {
    while(n){
      //2로 나눠 떨어지면
      if(!(n%-2))
      {
        str += "0";
        n /= -2;
      }
      //2로 나눠 떨어지지 않으면
      else 
      {
        str += "1";
        n = (n-1)/-2;
      }
    }
  }

  reverse(str.begin(), str.end());
	cout << str << '\n';
}