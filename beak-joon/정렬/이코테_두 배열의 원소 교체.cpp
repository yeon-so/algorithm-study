#include<iostream>
#include<algorithm>
#include<vector>

/*
    두 개의 배열 A, B 은 N 개의 원소로 구성되어 있으며
    배열의 원소는 모두 자연수이다.
    최대 K 번의 바꿔치기 연산(A 원소 하나와 B 원소 하나 교체)을
    시도하여 배열 A의 모든 원소의 합이 최댓닶을 출력하는
    프로그램을 작성하시오.
*/

using namespace std;

bool compare(int x, int y)
{
	return x > y;	
}

int main()
{
	int n,k;
	cin >> n >> k;

	vector<int> av;
	vector<int> bv;

	int result = 0;

	// 배열 A 입력
	for(int i = 0; i < n; i++)
	{
		int a;
		cin >> a;
		av.push_back(a);
	}

	// 배열 B 입력
	for(int i = 0; i < n; i++)
	{
		int b;
		cin >> b;
		bv.push_back(b);
	}

	// a 는 내림차순
	sort(av.begin(), av.end());
	// b 는 오름차순
	sort(bv.begin(), bv.end(), compare);

	// a b K번째 만큼 비교하며 변경 
	for(int i = 0; i < k; i++)
	{
		if(av[i] < bv[i])
		{
			int temp;
			temp = av[i];
			av[i] = bv[i];
			bv[i] = temp;
		}
	}

	// A 배열 원소 합
	for(int i = 0; i < n; i++)
	{
		result += av[i];
	}
	
	// 원소 합의 최댓값 출력
	cout << result;
}