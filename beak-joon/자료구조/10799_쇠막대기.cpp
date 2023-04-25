#include<iostream>
#include<string>
#include<stack>

using namespace std;

int main()
{
  string str;
  int result = 0;

  ios::sync_with_stdio(false);
  cin.tie(nullptr);

  cin >> str;

  stack<char> ch;

  for(int i =0; i<str.length(); i++)
  {
    if(str[i] == '(') { // str이 ( 이면 스택에 넣음 
      ch.push(str[i]);
    } 
    else // str이 )이면
    {
      if(str[i-1] == '(') //() 레이저인 경우
      {
        ch.pop(); // 앞에 넣은 ( 뺀다. 즉 레이저에서 잘리니 제거
        result += ch.size(); // 레이저 전 막대의 개수만큼 추가
      }
      else { //막대의 끝인 경우 )일 경우
        ch.pop(); // 앞에 넣은 ( 또 뺀다. 끝을 만났으니 한줄 제거
        result += 1; // 막대의 끝까지 같으니 1 절단된 사항 1 추가
      }
    }
  }

  cout << result << '\n';

}