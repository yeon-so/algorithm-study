#include <iostream>
using namespace std;

int main()
{
  int arr[101];
  int n;
  int result = 0;
  cin >> n;

  for(int i= 0; i < n; i++)
  {
    cin >> arr[i];
    int cnt = 0;

    for(int j = 1; j <= arr[i]; j++)
    {
      //나머지가 0 : 즉 나눠떨어지면
      if(arr[i]%j == 0)
      {
        ++cnt;
      }

    }

    if(cnt == 2)
    {
      result++;
    }
    
  }

  cout << result << '\n';

}