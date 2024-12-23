#include<iostream>

using namespace std;

typedef struct node
{
	char left;
	char right;
} NODE;

NODE arr[27];

// 전위 순회 root > left > right
void prev(char x)
{
	if(x == '.') return;
	// 현재 노트값 출력
	cout << x;
	// 왼쪽 자식 호출
	prev(arr[x - 'A'].left);
	// 오른쪽 자식 호출
	prev(arr[x - 'A'].right);
}

// 중위 순회 left > root > right
void in(char x)
{
	if(x == '.') return;
	// 왼쪽 자식 호출
	in(arr[x - 'A'].left);
	// 현재 노트값 출력
	cout << x;
	// 오른쪽 자식 호출
	in(arr[x - 'A'].right);
}

// 후위 순회 left > right > root
void post(char x)
{
	if(x == '.') return;
	// 왼쪽 자식 호출
	post(arr[x - 'A'].left);
	// 오른쪽 자식 호출
	post(arr[x - 'A'].right);
	// 현재 노트값 출력
	cout << x;
}

int main() 
{
	int temp;
	cin >> temp;

	for(int i = 0; i < temp; i++)
	{
		char a,b,c;
		cin >> a >> b >> c;
		arr[a - 'A'].left = b;
		arr[a - 'A'].right = c;
	}

	prev('A');
	cout << '\n';
	in('A');
	cout << '\n';
	post('A');
	cout << '\n';
}

