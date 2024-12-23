#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

/*
  8진수를 2진수로 변환하는 법
  1) 8 -> 10 -> 2
  2) 8 -> 2
  1373 를 참고하여 2번 방법으로 풀어보았다.
*/

int main()
{
  //0~7까지 값을 2진수로 변환한 값을 넣은 배열
  string arr[8] = {"000","001","010","011","100","101","110","111"};
  string str;

  cin >> str;

  // 0 일때는 0 출력
  if(str == "0")
  {
    cout << 0 ;
  }
  else
  {
    for(int i = 0; i < str.length(); i++)
    {
      //각 자리수에 해당되는 2진수 3자리 할당
      // 1 > 001 2 > 010 ...
      string temp = arr[str[i] - '0'];
    
      int index = -1;
      // 첫번째 수라면 처음에 0이 오면 안된다.
      if(i == 0)
      {
        for(int j =0; j < temp.length(); j++)
        {
          //처음 1이 나오면 해당 자리수를 얻고 제어문을 나간다.
          if(temp[j] == '1')
          {
            index = j;
            break;
          }
        }
        // 1이 나오기 전까지의 문자열을 지운다
        temp.erase(0, index);
        //temp.erase(remove(temp.begin(), temp.end(), '0'), temp.end());
      }

      cout << temp ;
    
    }
  }
}