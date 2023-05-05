#include <iostream>
#include <string>

using namespace std;

int main()
{
  string str;
  cin >> str;

  int alpha[26];

  // alpha 배열 -1로 초기화
  for(int i =0; i < 26; i++)
  {
    alpha[i] = -1;
  }

  // 문자열 길이만큼 반복
  for(int i = 0; i < str.length(); i++)
  {
    // 97~123(a-z) - 97~123 = 0~25
    // 해당 알파벳 배열의 인덱스를 temp로 선언
    int temp = str[i] - 97;

    // 처음 순서만 저장 (중복 시 넘어감)
    if(alpha[temp] == -1)
      alpha[temp] = i;
  }

  for(int i = 0; i < 26; i++)
  {
    cout << alpha[i] << '\n';
  }

}
