#include <iostream>
#include <string>
#include <stack>
#include <algorithm>

using namespace std;

int main()
{
  //커서의 왼쪽 문자를 담을 stack
  stack<char> left;
  //커서의 오른쪽 문자를 담을 stack
  stack<char> right;
  string str;
  int num;

  //초기 문자열 입력
  cin >> str;
  //left에 데이터 복사
  for(int i = 0; i < str.size(); i++)
  {
    left.push(str[i]);
  }
  //입력 횟수 입력
  cin >> num;

  for(int i = 0; i < num; i++)
  {
    char c; 
    cin >> c;

    //커서를 왼쪽으로 한칸 이동
    if(c == 'L')
    {
      // 문장의 맨앞이 아니면(왼쪽이 비어있지 않으면)
      if(!left.empty())
      {
        right.push(left.top());
        left.pop();

      }
    }
    //커서를 오른쪽으로 한칸 이동
    else if(c == 'D')
    {
      // 문장의 맨뒤이 아니면(오른쪽이 비어있지 않으면)
      if(!right.empty())
      {
        left.push(right.top());
        right.pop();

      }
    } 
    // 커서 왼쪽에 있는 문자 삭제
    else if(c == 'B')
    {
      // 문장의 맨앞이 아니면(왼쪽이 비어있지 않으면)
      if(!left.empty())
      {
        left.pop();
      }
    }
    // 문자를 커서 왼쪽에 추가함
    else if(c == 'P')
    {
      char t;
      cin >> t;
      left.push(t);
    }
  }

  // left 값을 right 로 넣으면서 정렬
  while (!left.empty())
  {
    right.push(left.top());
    left.pop();
  }
  // 최종 결과 출력
  while (!right.empty())
  {
    cout << right.top();
    right.pop();
  }
  
}