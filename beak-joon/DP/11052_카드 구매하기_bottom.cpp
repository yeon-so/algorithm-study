#include <iostream>
#include <algorithm>

using namespace std;

int d[1001];

int main(void) {
    
    int n;
    cin >> n;
    int arr[n+1] = {0,};

    for(int i =1; i<=n; i++)
    {
        cin >> arr[i];
    }

    for(int j = 1; j <=n; j++)
    {
        d[j] = arr[j];
        for(int i = 1; i <= j; i++)
        {
            d[j] = max(d[j], d[j-i]+d[i]);
        }
    }

    cout << d[n] << endl;
}