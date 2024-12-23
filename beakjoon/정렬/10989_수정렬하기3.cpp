#include <iostream>
using namespace std;

// 1. 1 ≤ N ≤ 10,000,000 이라는 범위는 너무 크기때문에
// 2. 입력수가 10000 까지 범위임으로 해당 값의 갯수를 배열로 저장한다.
int arr[10001] = {0,};

int main(void){

  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  
  int n;

  cin >> n;

  for(int i = 0; i < n; i++)
  {
    int x;
    cin >> x;
    arr[x] += 1; 
  }

  for(int i = 0; i < 10001; i++)
  {
    for(int j =0; j < arr[i]; j++)
    {
      cout << i << '\n';
    }
  }

}