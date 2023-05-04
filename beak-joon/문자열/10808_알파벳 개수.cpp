#include <iostream>
#include <string>

using namespace std;

int main()
{
  string str;
  cin >> str;

  int alpha[26] = {0,};

  for(int i = 0; i < str.length(); i++)
  {
    int temp = str[i] - '0' - 49 ;
    alpha[temp] += 1;
  }

  for(int i = 0; i < 26; i++)
  {
    cout << alpha[i] << '\n';
  }

}