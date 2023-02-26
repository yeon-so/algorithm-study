#include<iostream>

using namespace std;

//각 달의 수 31,28,31,30,31,30,31,31,30,31,30,31
//요일 SUN, MON, TUE, WED, THU, FRI, SAT
//7로 나눴을때 나머지가 1일 경우 MON

int main(void){

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int month[12] = {31,28,31,30,31,30,31,31,30,31,30,31};

    int x,y,result;

    cin >> x >> y;

    //달 수 더하기 2월 -> +31(1월 일 수)
    for(int i = 0; i < x-1; i++){
        result += month[i];
    }

    //나머지 일 수 더하기
    result += y;

    //switch, if, 요일을 배열에 넣어 할 결과 도출 가능
    if(result % 7 == 1){
        cout << "MON" << '\n';
    }
    else if(result % 7 == 2){
        cout << "TUE" << '\n';
    }
    else if(result % 7 == 3){
        cout << "WED" << '\n';
    }
    else if(result % 7 == 4){
        cout << "THU" << '\n';
    }
    else if(result % 7 == 5){
        cout << "FRI" << '\n';
    }
    else if(result % 7 == 6){
        cout << "SAT" << '\n';
    }
    else if(result % 7 == 0){
        cout << "SUN" << '\n';
    }

    return 0;
}