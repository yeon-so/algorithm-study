#include<iostream>
#include<queue>
#include<string>

using namespace std;

queue<int> q;

int main()
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
      q.push(x);
    }
    else if(str == "pop")
    {
      if(!q.empty())
      {
        cout << q.front() << '\n';
        q.pop();
      }
      else
      {
        cout << -1 << '\n';
      }
    }
    else if(str == "size")
    {
      cout << q.size() << '\n';
    }
    else if(str == "empty")
    {
      if(!q.empty())
      {
        cout << 0 << '\n';
      }
      else
      {
        cout << 1 << '\n';
      }
    }
    else if(str == "front")
    {
      if(!q.empty())
      {
        cout << q.front() << '\n';
      }
      else
      {
        cout << -1 << '\n';
      }
    }
    else if(str == "back")
    {
      if(!q.empty())
      {
        cout << q.back() << '\n';
      }
      else
      {
        cout << -1 << '\n';
      }
    }

  }

}