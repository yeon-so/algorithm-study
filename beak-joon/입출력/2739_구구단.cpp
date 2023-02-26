#include<iostream>

using namespace std;

int main(void){

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n = 0;

    cin >> n;

    for(int i=1; i<10; i++){
        cout << n << " * " << i << " = " << n*i << '\n';
    }

    return 0;
}