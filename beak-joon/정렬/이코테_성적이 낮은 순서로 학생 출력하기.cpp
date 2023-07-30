#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

bool compare(pair<int,string> x, pair<int,string> y)
{
	return x.first < y.first;
}

int main()
{
	int n;
	cin >> n;
	vector<pair<int,string>> v(n);

	for(int i = 0; i < n; i++)
	{
		int score;
		string name;
		cin >> name >> score;

		v[i].first = score;
		v[i].second = name;
	}

	sort(v.begin(),v.end(),compare);

	for(int i = 0; i < v.size(); i++)
	{
		cout << v[i].second << " ";
	}
}