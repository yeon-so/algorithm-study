#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

int n, m;
int target;
vector<int> arr;
vector<int> targets;

// 이진 탐색 소스코드 구현 (반복문)
int binarySearch(vector<int>& arr, int target, int start, int end)
{
	while ( start <= end ){
		int mid = (start + end) / 2;
		
		if (arr[mid] == target) return mid;
		else if (arr[mid] > target) end = mid -1;
		else start = mid + 1;
	}

	return -1;
}

int main(void)
{
    
	cin >> n;
	for(int i = 0; i < n; i++){
		int x;
		cin >> x;
		arr.push_back(x);
	}

	sort(arr.begin(), arr.end());

	cin >> m;
	for(int i = 0; i < m; i++){
		cin >> target;
		targets.push_back(target);
	}

	for(int i = 0; i < m; i++){
		int result = binarySearch(arr, targets[i], 0, n-1);
		if( result != -1) {
			cout << "yes" << ' ' ;
		}
		else {
			cout << "no" << ' ' ;
		}
	}

}