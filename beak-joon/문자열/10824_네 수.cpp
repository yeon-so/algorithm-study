#include<iostream>
#include<string>

using namespace std;

int main()
{
  string str1, str2, str3, str4;

  cin >> str1 >> str2 >> str3 >> str4;

  string temp1 = str1 + str2;
  string temp2 = str3 + str4;

  long long result = stoll(temp1) + stoll(temp2);

  cout << result << '\n';
}