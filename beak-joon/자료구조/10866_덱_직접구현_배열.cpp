#include<iostream>
#include<string>

using namespace std;

#define MAX 10000

class Deque {
  int front; // 첫번째 요소 index
  int rear;  // 마지막 요소 index
  int data[MAX]; // 실 데이터

  public:
  Deque()
  {
    front = 0;
    rear = 0;
  }

  //정수 X를 덱의 앞에 넣는다.
  void push_front(int x)
  {
    data[front] = x;
    // front 가 0 이하로 떨어지는 경우 max index로 순회
    front = (front-1+MAX)%MAX;
  }

  //정수 X를 덱의 뒤에 넣는다.
  void push_back(int x)
  {
    // rear가 max를 넘어가는 경우 다시 0번째 index로 순회
    rear = (rear+1)%MAX;
    data[rear] = x;
  }

  //덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
  int pop_front()
  {
    if(empty())
    {
      return -1;
    }

    front = (front+1)%MAX;
    return data[front];
  }

  //덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
  int pop_back()
  {
    if(empty())
    {
      return -1;
    }

    int temp = data[rear];
    rear = (rear-1+MAX)%MAX;
    return temp;
  }

  //덱에 들어있는 정수의 개수를 출력한다.
  int size(){
    return front<=rear ? rear-front : (rear+MAX)-front;
  }

  //덱이 비어있으면 1을, 아니면 0을 출력한다.
  int empty(){
    return front == rear;
  }

  //덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
  int front1(){
    if(empty())
    {
      return -1;
    }
    return data[(front+1)%MAX];
  }

  //덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
  int back1(){
    if(empty())
    {
      return -1;
    }
    return data[rear];
  }
};

int main()
{
  int cnt;
  string str;
  Deque dq;
  cin >> cnt;

  for(int i = 0; i < cnt; i++)
  {
    cin >> str;
    int x;

    if(str == "push_front")
    {
      cin >> x;
      dq.push_front(x);
    }
    else if(str == "push_back")
    {
      cin >> x;
      dq.push_back(x);
    }
    else if(str == "pop_front")
    {
      cout << dq.pop_front() << '\n';
    }
    else if(str == "pop_back")
    {
      cout << dq.pop_back() << '\n';
    }
    else if(str == "size")
    {
      cout << dq.size() << '\n';
    }
    else if(str == "empty")
    {
      cout << dq.empty() << '\n';
    }
    else if(str == "front")
    {
      cout << dq.front1() << '\n';
    }
    else if(str == "back")
    {
      cout << dq.back1() << '\n';
    }
  }

}