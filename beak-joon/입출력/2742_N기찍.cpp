#include<iostream>

using namespace std;

int main(void){

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n = 0;

    cin >> n;

    for(int i=n; i>0; i--){
        cout << i << '\n';
    }

    return 0;
}