#include<iostream>
#include<string>
#define MAX_QUEUE_SIZE 10000

using namespace std;

class Queue
{

  int data[MAX_QUEUE_SIZE];
  int front; //처음
  int rear; //끝

  public:
  Queue() {
    front = 0;
    rear = 0;
  }

  void push(int x)
  {
    data[rear] = x;
    rear++;
  }

  int pop()
  {
    if(!isEmpty())
    {
      int r = data[front];
      data[front] = 0;
      front += 1;
      return r;
    }
    else
    {
      return -1;
    }
  }

  int getSize()
  {
    return rear-front;
  }

  bool isEmpty()
  {
    if(rear-front == 0)
    {
      return 1; // true
    }
    else
    {
      return 0; // false
    }
  }

  int getFront()
  {
    if(!isEmpty())
    {
      return data[front];
    }
    else
    {
      return -1;
    }
  }

  int getBack()
  {
    if(!isEmpty())
    {
      return data[rear-1];
    }
    else
    {
      return -1;
    }
  }

};

int main()
{

  Queue q;
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
      cout << q.pop() << '\n';
    }
    else if(str == "size")
    {
      cout << q.getSize() << '\n';
    }
    else if(str == "empty")
    {
      cout << q.isEmpty() << '\n';
    }
    else if(str == "front")
    {
      cout << q.getFront() << '\n';
    }
    else if(str == "back")
    {
      cout << q.getBack() << '\n';
    }
  }

}