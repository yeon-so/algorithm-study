#include<iostream>

using namespace std;

int main(void){

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n = 0;

    cin >> n;

    for(int i=1; i<n+1; i++){
        cout << i << '\n';
    }

    return 0;
}