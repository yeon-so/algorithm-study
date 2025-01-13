#include<iostream>
#include<deque>
#include<algorithm>
#include<string>

using namespace std;

deque<int> dq;

int main()
{
  int c,n;
  string str;
  //횟수 입력
  cin >> c;

  for(int i = 0; i < c; i++)
  {
    cin >> str;

    if(str == "push_front")
    {
      cin >> n;
      dq.push_front(n);
    }
    else if(str == "push_back")
    {
      cin >> n;
      dq.push_back(n);
    }
    else if(str == "pop_front")
    {
      if(dq.empty())
      {
        cout<< -1 << '\n';
      }
      else
      {
        cout << dq.front() << '\n';
        dq.pop_front();
      }
    }
    else if(str == "pop_back")
    {
      if(dq.empty())
      {
        cout<< -1 << '\n';
      }
      else
      {
        cout << dq.back() << '\n';
        dq.pop_back();
      }
    }
    else if(str == "size")
    {
      cout << dq.size() << '\n';
    }
    else if(str == "empty")
    {
      if(dq.empty())
      {
        cout<< 1 << '\n';
      }
      else
      {
        cout<< 0 << '\n';
      }
    }
    else if(str == "front")
    {
      if(dq.empty())
      {
        cout<< -1 << '\n';
      }
      else
      {
        cout << dq.front() << '\n';
      }
    }
    else if(str == "back")
    {
      if(dq.empty())
      {
        cout<< -1 << '\n';
      }
      else
      {
        cout << dq.back() << '\n';
      }
    }
  }
  
}