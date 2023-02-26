#include<iostream>

using namespace std;

int a, b, t;

int main(void) {

    cin >> t;

    for(int i = 0; i < t; i++)
    {
        cin >> a >> b ;
        cout << a+b << '\n';
    }

    return 0;
}