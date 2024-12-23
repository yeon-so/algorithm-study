#include<iostream>
#include<stack>
#include<string>

using namespace std;

bool check(string str)
{
  int len = (int)str.length();
  stack<char> st;

  for(int i = 0; i < len; i++)
  {
    char c = str[i];

    if(c == '(')
    {
      st.push(c);
    }
    else
    {
      if(!st.empty())
      {
        st.pop();
      }
      else
      {
        return false;
      }
    }
  }
  return st.empty();
}

int main(void)
{

  int n;
  cin >> n;

  for(int i = 0; i < n; i++)
  {
    string str;
    cin >> str;

    if(check(str))
    {
      cout << "YES" << '\n';
    }
    else
    {
      cout << "NO" << '\n';
    }
  }

}