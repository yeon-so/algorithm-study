#include<iostream>
#include<string.h>

using namespace std;

int t;
string a;

int main(void) {

    cin >> t;

    for(int i=0; i<t; i++)
    {
        cin >> a;
        cout << (a[0]-'0') + (a[2]-'0') << '\n';
    }

    return 0;
}

/* 
    int a,b,t;
    char s;
    
int main(void) {

    cin >> t;

    for(int i=0; i<t; i++)
    {
        cin >> a >> s >> b ;
        cout << a + b << endl;
    }

    return 0;
}
*/