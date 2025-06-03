#include<iostream>
using namespace std;

long long gcd(long long a, long long b)
{
  while(b != 0)
  {
      long long r = a%b;
      a = b;
      b = r;
  }

  return a;
}

int main()
{
  long long a, b, r;

  cin >> a >> b;

  /*최대공약수
    2개의 자연수 a, b(a > b)에 대해서 
    a를 b로 나눈 나머지가 r일 때, 
    a와 b의 최대공약수는 b와 r의 최대공약수와 같다.
  */

 //a를 큰값으로 바꿔준다.
 if( b > a )
 {
    long long temp;
    temp = a;
    a = b;
    b = temp;
 }

 long long n = gcd(a,b);

 // 3 4 -> 1 => 1
 // 3 6 -> 3 => 111
 // 즉 나온 공약수의 값만큼 1을 출력하면 답
 for(int i =0; i <n; i++)
 {
    cout << 1;
 }
  
}