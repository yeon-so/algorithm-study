#include <iostream>
using namespace std;

long long p[101];

int main(void)
{
    int T;
    cin >> T;

    int n[T];
    
    p[0] = 0;
    p[1] = 1;
    p[2] = 1;
    p[3] = 1;

    for(int i = 0; i < T; i++)
    {
        cin >> n[i];
    }

    for(int i = 0; i < T; i++)
    {
        for(int j = 4; j <= n[i]; j++)
        {
            p[j] = p[j-3] + p[j-2];
        }
        cout << p[n[i]] << '\n';
    }

}