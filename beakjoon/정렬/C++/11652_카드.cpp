#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void)
{
  int count = 0;
  int max = 0;
  long long result = 0;

  int n;
  cin >> n;

  //-26^2보다 크거나 같고, 26^2보다 작거나 같기 때문에 long long
  vector<long long> arr(n);

  //입력받기
  for(int i = 0; i < n; i++)
  {
    cin >> arr[i];
  }

  //오름차순으로 나열
  sort(arr.begin(), arr.end());

  //초기값
  result = arr[0];

  for(int i = 1; i < n; i++)
  {
    //앞 뒤 숫자가 같으면 카운트 증가
    if(arr[i-1] == arr[i])
    {
      count++;
    }
    // 다음수로 넘어가면 0으로 카운트 초기화
    else
    {
      count = 0;
    }

    //count=max값이 가장 높은 수를 결과값으로 저장 
    if(count > max){
      max = count;
      result = arr[i];
    }
  }

  cout << result << '\n';

}