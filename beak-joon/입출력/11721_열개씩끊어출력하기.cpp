#include<iostream>
#include<string>

using namespace std;

string str;
    
int main(void) {

    getline(cin, str);

    for(int i = 0; i < str.length(); i++){
        cout << str[i];
        if(i % 10 == 9) // 나머지가 9면 개행
        {
            cout << '\n';
        }
    }

    return 0;
}