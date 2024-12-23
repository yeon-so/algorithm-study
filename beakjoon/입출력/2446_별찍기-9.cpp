#include <iostream>
using namespace std;

int main (void) {

    int n;

    cin >> n;

    for(int i = 1; i <= n; i++){
        for(int j = 0; j < i-1; j++){
            cout << " ";
        }
        for(int k = 0; k <= (n*2)-(i*2); k++){
            cout << "*";
        }
        cout << '\n';
    }

    for(int i = 1; i < n; i++){
        for(int k = 0; k < n-i-1; k++){
            cout << " ";
        }
        for(int j = 0; j < (i*2)+1; j++){
            cout << "*";
        }
        cout << '\n';
    }

    return 0;
}