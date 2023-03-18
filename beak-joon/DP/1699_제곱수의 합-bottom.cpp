#include <iostream>
#include <algorithm>

using namespace std;

int d[100001];

int main(void)
{
    int n;
    cin >> n;

    for(int i = 1; i <= n ; i++)
    {
        d[i] = i;
        for(int j = 1; j*j <= i; j++){
            d[i] = min(d[i], d[i-(j*j)] + 1);
        }
    }

    cout << d[n] << '\n';
}