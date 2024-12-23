#include <iostream>
using namespace std;

int main(void) {
    
    int n;

    cin >> n;

    for(int i = 1; i <= n; i++){
        for(int k = 1; k<= n-i; k++){
            cout << " ";
        }
        
        if(i ==1 || i ==n)
        {
            for(int j =0; j<(i*2)-1; j++)
            {
                cout << "*";
            }
        }
        else{

            cout << "*";
            for(int k = 2; k < (i*2)-1; k++){
                cout << " ";
            }
            cout << "*";

        }

        cout << '\n';
    }
}