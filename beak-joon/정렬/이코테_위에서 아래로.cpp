#include<iostream>
#include<algorithm>
#include<vector>

/*
	하나의 수열에는 다양한 수가 존재한다.
	이러한 수는 크기에 상관없이 나열되어 있다.
	이 수를 큰 수부터 작은 순서로 정렬해야 한다.
	수열을 내림차순으로 정렬하는 프로그램을 만드시오.
*/

using namespace std;

bool compare(int i, int j)
{
	return i > j;
}

int main()
{
	int n;
	cin >> n;
	vector<int> v(n);

	for(int i = 0; i < n; i++)
	{
		int temp;
		cin >> temp;

		v[i]=temp;
	}

	sort(v.begin(),v.end(),compare);

	for(int i = 0; i < v.size(); i++)
	{
		cout << v[i] << " ";
	}
}