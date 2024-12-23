#include<iostream>
#include<queue>

using namespace std;

int main()
{
  //N명의 사람의 원을 그릴 배열
  queue<int> circle;

  int N;
  int K;
  //현재 위치
  int temp = 0;

  cin >> N;
  cin >> K;

  //1 ~ N명까지 원을 채운다.
  for(int i = 1; i <= N; i++)
  {
    circle.push(i);
  }

  cout << "<";
  while(!circle.empty())
  {
    //K번째 수라면 해당 수 빼기
    if( temp == K-1 )
    {
      // 마지막 수라면 "," 안붙이기
      if( circle.size() == 1 )
      {
        cout << circle.front() ;
      }
      // 마지막 수가 아니면 ", " 붙이기
      else
      {
        cout << circle.front() << ", ";
      }
      circle.pop();
      temp = 0;
    }
    //K번째 수가 아니면 다시 그 수를 뒤로 보냄
    else{
      circle.push(circle.front());
      circle.pop();
      temp++;
    }

  }
  cout << ">";
}
