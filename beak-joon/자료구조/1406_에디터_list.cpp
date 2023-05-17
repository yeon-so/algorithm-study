#include<string>
#include<iostream>
#include<list>

using namespace std;

int main() 
{
  string str = "";
  int num;

  // 초기 문자열 입력
  cin >> str;
  // 연결리스트에 원소 할당
  list<char> l(str.begin(), str.end());
  // 현재 커서 위치
  auto cur = l.end();
  //명령어 갯수 입력
  cin >> num;

  for(int i = 0; i < num; i++)
  {
    char tmp, c;
    cin >> tmp;

    // 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
    if( tmp == 'L')
    {
      // L.front() 와 헷갈리지 않기
      if(cur != l.begin())
      {
        cur--;
      }
    }
    // 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
    else if( tmp == 'D')
    {
      if(cur != l.end())
      {
        cur++;
      }
    }
    //커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
    else if( tmp == 'B')
    {
      if(cur != l.begin())
      {
        cur--;
        //erase는 삭제 후 cursor의 주소를 반환
        //따라서 iterator에 저장해두지 않으면 원래 커서는 길을 읽는다.
        cur = l.erase(cur);
      }
    }
    //$라는 문자를 커서 왼쪽에 추가함
    else if ( tmp == 'P')
    {
      cin >> c;
      l.insert(cur, c);
    }
  }

  // 연결리스트 출력
  for (cur = l.begin(); cur != l.end(); cur++) {
    cout << *cur;
  }

}