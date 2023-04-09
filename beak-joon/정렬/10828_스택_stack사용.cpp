#include <iostream>
#include <string>
#include <stack>

using namespace std;

stack<int> s;

int main(void)
{
  int n, x;
  cin >> n;
  string str;
  
  for(int i = 0; i < n; i++)
  {
    cin >> str;
    
    if(str == "push")
    {
      cin >> x;
      s.push(x);
    } 
    else if(str == "pop")
    {   
      if(!s.empty())
      {
        cout << s.top() << '\n';
        s.pop();
      }
      else
      {
        cout << "-1" << '\n';
      }

    } 
    else if(str == "size")
    {
      cout << s.size() << '\n';
    }
    else if(str == "empty")
    {
      cout << s.empty() << '\n';
    }
    else if(str == "top")
    {
      if(!s.empty())
      {
        cout << s.top() << '\n';
      }
      else
      {
        cout << "-1" << '\n';
      }
    }
  }
  
}