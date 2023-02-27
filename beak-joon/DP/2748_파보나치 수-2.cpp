int main (void) {

    int n = 0;
    int result = 0;
    cin >> n;
    long long int  pabo[91] = {0,};

    pabo[0] = 0;
    pabo[1] = 1;

    for(int i = 2 ; i < 91; i++){
        pabo[i] = pabo[i-2] + pabo[i-1];
    }

    cout << pabo[n] << endl;
}

/* 함수 이용
    #include<iostream>
    using namespace std;

    //전역으로 선언시 자동으로 0으로 초기화
    long long int arr[100];

    long long int d(int x){

        if(x ==1 || x == 2) return 1;
        // 한번 구한 값이라면 처음 계산 후 저장된 값을 반환
        if(arr[x] !=0) return arr[x];
        return arr[x] = d(x-1) + d(x-2);
    }

    int main(void){

        int n = 0;
        cin >> n;

        cout << d(n) << '\n';
    }
*/