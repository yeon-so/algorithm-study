#include <iostream>
using namespace std;

int main() {

    ios_base::sync_with_stdio(false); // 동기화 해제
    
    int num;
    cin >> num;

    for(int i=1; i<=num; i++){
        int a,b;
        cin >> a >> b;
        cout << "Case #" << i << ": " << a << " + " << b << " = " << a+b << "\n";
    }

    return 0;
}