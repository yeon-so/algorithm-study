#include <iostream>
using namespace std;

int main (void) {

    int n;

    cin >> n;

    for(int i = 1; i <= n; i++){
        for(int j = 0; j < i; j++){
            cout << "*";
        }
        for(int k = 0; k < (n*2)-(i*2); k++){
            cout << " ";
        }
        for(int j = 0; j < i; j++){
            cout << "*";
        }
        cout << '\n';
    }

    for(int i = 1; i < n; i++){
        for(int j = 0; j < (n-i); j++){
            cout << "*";
        }
        for(int k = 0; k < (n*2)-((n-i)*2); k++){
            cout << " ";
        }
        for(int j = 0; j < (n-i); j++){
            cout << "*";
        }
        cout << '\n';
    }

    return 0;
}