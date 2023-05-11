#include <iostream>
#include <string>

using namespace std;

int main() 
{
  string str;
 
  /*
    cin 으로 입력을 받으면 엔터나 스페이스 바를 입력 시 입력이 종료된다.
    따라서 이떄는 getline(cin,str)를 사용한다.
  */
  getline(cin, str);

  for(int i = 0; i < str.size(); i++)
  {
    if(str[i] >= 'a' && str[i] <= 'm' )
    {
      str[i] += 13;
    }
    else if(str[i] >= 'n' && str[i] <= 'z' )
    {
      str[i] -= 13;
    }
    else if(str[i] >= 'A' && str[i] <= 'M' )
    {
      str[i] += 13;
    }
    else if(str[i] >= 'M' && str[i] <= 'Z' )
    {
      str[i] -= 13;
    }
  }
  cout << str << '\n';
}