#include <iostream>
using namespace std;

int main (void) {

    int n;

    cin >> n;

    for(int i =n; i > 0; i--){
        for(int j = 0; j < n-i; j++){
            cout << " ";
        }
        for(int k = i; k > 0; k--){
            cout << "*";
        }
        cout << '\n';
    }

    return 0;
}