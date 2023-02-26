#include<iostream>
#include<string>

using namespace std;

    string str;
    
int main(void) {

    ios_base::sync_with_stdio(false); //동기화 해제
    cin.tie(NULL);
    cout.tie(NULL);

    while(1){
        getline(cin, str);
        if(str == ""){ //공백으로 입력 시 반환 
            break;
        }
        cout << str << '\n';
    }

    return 0;
}
