#include<iostream>
using namespace std;

#define MAX 1000000

//소수 식별 => 0이면 소수
int arr[MAX+1] = {0,};

int main()
{
  //까먹지 말자.. 이걸로 시간 초과 걸림...
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  bool chwr = false;
  
  for(int i = 2; i*i <= MAX; i++)
  {
    if(arr[i] == 0) {
      for(int j = i * i; j <= MAX; j +=i)
      {
        arr[j] = 1;
      }
    }
  }

  int n;
  while (1)
  {
    cin >> n;
    if(n==0)
      break;

    //두 홀수 소수의 합
    for(int i = 3; i <= n; i+=2)
    {
      if(arr[i] == 0 && arr[n-i] ==0)
      {
        chwr = true;
        cout << n << " = " << i << " + "<< n-i << '\n' ;
        break;
      }
    }

    if(!chwr)
      cout << "Goldbach's conjecture is wrong. \n";
  }
  

}

/*
#include<iostream>
using namespace std;

#define MAX 1000000

//소수 식별 => 0이면 소수
int arr[MAX+1] = {0,};

int main()
{
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);  

  bool chwr = false;
  
  for(int i = 2; i <= MAX; i++)
  {
    if(arr[i] == 0) {
      for(int j = i * 2; j <= MAX; j +=i)
      {
        arr[j] = 1;
      }
    }
  }

  int n = -1;
  while (n != 0)
  {
    cin >> n;

    //두 홀수 소수의 합
    for(int i = 3; i < n; i+=2)
    {
      if(arr[i] == 0 && arr[n-i] ==0)
      {
        chwr = true;
        cout << n << " = " << i << " + "<< n-i << '\n' ;
        break;
      }
    }

    if(!chwr)
      cout << "Goldbach's conjecture is wrong. \n";
  }
  

}
*/

/*
#include<iostream>
using namespace std;

#define MAX 1000000

//소수 식별 => 0이면 합성수
int arr[MAX+1] = {0,};

int main()
{

  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
    
  bool chwr = false;
  for(int i= 2; i <= MAX; i++)
  {
    arr[i] = i;
  }
  
  for(int i = 2; i <= MAX; i++)
  {
    if(arr[i] == 0) continue;
    for(int j = i * 2; j <= MAX; j +=i)
    {
      if(arr[j] == 0) 
        continue;
      else arr[j] = 0;
    }
  }

  int n = -1;
  while (n != 0)
  {
    cin >> n;

    //두 홀수 소수의 합
    for(int i = 3; i < n; i++)
    {
      if(arr[i] != 0 && arr[n-i] !=0)
      {
        chwr = true;
        cout << n << " = " << arr[i] << " + "<< arr[n-i] << '\n' ;
        break;
      }
    }

    if(!chwr)
      cout << "Goldbach's conjecture is wrong." << '\n';
  }
  

}
*/