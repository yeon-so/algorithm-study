#include <iostream>
#include <stack>
#include <math.h>
using namespace std;

int main() {
	// a진법, b진법, a진법로 나타난 숫자의 자리수
	int a, b, m;
	cin >> a >> b;
	cin >> m;

	//10진법 변환 수 저장
	int dec = 0;
	
	//a진법 -> 10진법
	while (m--) {
		int num;
		cin >> num;
		dec += num*pow(a, m);
	}

	//정답을 stack에 저장 
  //10진법 -> b진법 변환시 b^0, b^1, b^2 .. 에 해당하는 값부터 변환됨
	stack<int> result;

  // b 진법으로 변환할 10진수 값
	int temp = dec;

	//10진법 -> b진법
	while (temp) {
		result.push(temp % b);
		temp /= b;		
	}

	//stack에 있는 값 하나씩 출력
	while (!result.empty()) {
		cout << result.top() << " ";
		result.pop();
	}

	return 0;
}