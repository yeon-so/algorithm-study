#include <iostream>
using namespace std;

/*
 2진수를 8진수로
 3자리 수씩 뗴어서 생각하면 된다.
 110 = 1*4 + 1*2 + 0*1 = 6
 11001100 = 11 001 100 = 614
*/
int main()
{
  string str;
  int first = 0;

  cin >> str;

  // 4 7 10 .. 3으로 나눈 나머지가 1 이면 str[0] = 1
  if(str.size()%3 == 1)
  {
    cout << str[0];
    first = 1;
  }
  // 5 8 11 .. 3으로 나눈 나머지가 2 이면 str[0]*2 + str[1]*1
  else if(str.size()%3 == 2)
  {
    int n;
    n = (str[0] - '0')*2 + (str[1] - '0')*1;  
    first = 2;
    cout << n;
  }

  // i 는 3 씩 증가
  for(int i = first; i < str.size(); i=i+3)
  {
    int n;
    n = (str[i] - '0')*4 + (str[i+1] - '0')*2 + (str[i+2] - '0')*1;  
    cout << n;
  }

}