#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
  string str;
  vector<string> v;

  cin >> str;

  //백터에 문자열 push_back
  // substr(i,count); i번째 문자부터 count 길이 만큼의 문자열 리턴
  for(int i = 0; i < str.size(); i++)
  {
    v.push_back(str.substr(i, str.size()));
  }

  sort(v.begin(), v.end());

  for(int i = 0; i < v.size(); i++)
  {
    cout << v[i] << '\n';
  }

}