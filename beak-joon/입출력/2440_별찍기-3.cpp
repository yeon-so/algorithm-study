#include <iostream>
using namespace std;

int main (void) {

    int n;

    cin >> n;

    for(int i = n+1; i > 1; i--){
        for(int k = 0; k < i-1; k++){
            cout << "*";
        }
        cout << '\n';
    }

    return 0;
}