#include <iostream>
#include <string.h>
using namespace std;

//10809 알파벳 찾기

int main() {
    
    char str[101]; //100자리까지 되니까
    int arr[26]; //소문자 갯수
    
    cin >> str;

    //소문자 -1로 초기화
    for(int i=0; i<26; i++)
    {
        arr[i] = -1;
    }
    
    //아스키 코드 a-z 까지 반복
    for(int i=97; i<123; i++)
    {
        //입력한 문자열까지
        for(int j=0; j<strlen(str); j++)
        {
            //만약 해당 문자가 해당 알파벳이라면
            if(str[j] == i)
            {
                //해당 알파벳에 문자열의 자리수를 넣는다.
                arr[i-97] = j;
                //처음 순서로 저장하고 싶으니 한번 만나면 반복문을 빠져나간다.
                break;
            }
        }
    }
    
     //결과 출력
    for(int i=0; i<26; i++)
    {
        cout << arr[i] << " " ;
    }
}