#include <iostream>

using namespace std;

int main()
{

  int T;
  
  cin >> T;

  for(int i = 0; i<T; i++)
  {
    int a;
    int b;
    // a*b;
    int c;
    //나머지
    int r;

    cin >> a >> b ;

    // 큰수를 a로 변경
    if( b > a )
    {
      int temp;
      temp = a;
      a = b;
      b = temp;
    }

    c = a*b;

    //최대 공약수 구하기
    /*
      2개의 자연수 a, b(a > b)에 대해서 
      a를 b로 나눈 나머지가 r일 때, 
      a와 b의 최대공약수는 b와 r의 최대공약수와 같다.
    */
    while(b != 0)
    {
      r = a%b;
      a = b;
      b = r;
    }

    //최대 공배수 구하기
    /*
      a와 b의 최소공배수는 a와 b의 곱을 
      a와 b의 최대공약수를 나눈 것과 같다. 
    */
    cout << c/a << '\n';
  }

}