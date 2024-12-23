#include<iostream>
#include<string>
#define MAX_STACK_SIZE 10000
using namespace std;

class Stack
{
  //스택 사이즈
  int size;
  //스택 데이터갑이 들어갈 배열
  int data[MAX_STACK_SIZE];

  public:
  //생성자 (size = 0으로 초기화)
  Stack() { size = 0; }

  //정수 x를 삽입
  void push(int x)
  {
    data[size] = x;
    size++;
  }

  int pop()
  {
    //스택에 들어있는 정수가 없는 경우 -1 출력
    if(isEmpty())
    {
      return -1;
    }
    //스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다.
    else
    {
      size--;
      return data[size];
    }
  }
  
  int top()
  {
    //스택에 들어있는 정수가 없는 경우 -1 출력
    if(isEmpty())
    {
      return -1;
    }
    //스택에서 가장 위에 있는 정수를 출력한다.
    else
    {
      return data[size-1];
    }
  }

  //스택에 들어있는 정수의 갯수를 출력한다.
  int getSize()
  {
    return size;
  }

  bool isEmpty()
  {
    //스택이 비어있으면 1, 아니면 0을 출력
    if(size == 0)
    {
      return 1; //true
    }
    else
    {
      return 0; //false
    }
  }
};

int main(void)
{
  ios::sync_with_stdio(false);

  int N;
  Stack s; // 클래스 Stack 구현
  cin >> N;

  for(int i = 0; i < N; i++)
  {
    string cmd;
    int data;

    cin >> cmd;

    if(cmd == "push")
    {
      cin >> data;
      s.push(data);
      
    }
    else if(cmd == "pop")
    {
      cout << s.pop() << '\n';
    }
    else if(cmd == "size")
    {
      cout << s.getSize() << '\n';
    }
    else if(cmd == "empty")
    {
      cout << s.isEmpty() << '\n';
    }
    else if(cmd == "top")
    {
      cout << s.top() << '\n';
    }
  }
  
}