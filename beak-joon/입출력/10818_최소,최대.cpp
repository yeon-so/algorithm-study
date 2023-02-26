#include <iostream>
#include <algorithm>
using namespace std;

int main (void) {

    int n;

    cin >> n;

    int arr[n] = {0,};// 0 으로 초기화

    for(int i =0; i<n; i++){
        cin >> arr[i];
    }

    //최대값, 최소값
    int min = 1000000;
    int max = -1000000;

    for(int i =0; i<n; i++){
        if(arr[i] < min){
            min = arr[i];
        }
        if(arr[i] > max ){
            max = arr[i];
        }
    }

    cout << min << " " << max << '\n';

    return 0;
}