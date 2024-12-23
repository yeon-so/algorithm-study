#include<iostream>
#include<string>

using namespace std;

int n;
int result;
string str;
    
int main(void) {

    cin >> n;
    cin.ignore(); // 버퍼 비우기, 안넣으면 getline에 공백이 포함되서 getline 넘어감
    getline(cin, str);

    for(int i = 0; i < str.length(); i++){
        result += (str[i]-'0');
    }

    cout << result << '\n';
    return 0;
}
