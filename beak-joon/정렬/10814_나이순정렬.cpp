#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(pair<int, string> a, pair<int, string> b)
{
    // 오름차순
    return a.first < b.first; 
}

int main()
{
  int n;
  cin >> n;

  vector<pair<int, string>> v;

  for(int i = 0; i < n; i++)
  {
    int x;
    string y;
    cin >> x >> y; 

    v.push_back(pair<int, string>(x,y));
  }

  sort(v.begin(), v.end(), compare);

  for(int i = 0; i < n; i++)
  {
    cout << v[i].first << " " << v[i].second << '\n';
  }
}