#include<iostream>
#include<algorithm>

using namespace std;

unsigned int arr[10001] = {0,};

int main()
{
	// 랜선의 개수 K, 필요한 랜선의 개수 N, 결과값 ans, K < N
	unsigned int K, N, ans;
	cin >> K >> N;

	unsigned int maxi = 0;

	for(int i = 0; i < K; i++)
	{
		cin >> arr[i];
		maxi = max(maxi, arr[i]);
	}

	unsigned int left = 1;
	unsigned int right = maxi;
	unsigned int mid;

	// 이진 탐색
	while( left <= right )
	{
		// mid 연산
		mid = ( left + right ) / 2;

		// 몫의 합을 저장하는 변수
		unsigned int now = 0;

		for(int i = 0; i < K; i++)
		{
			// mid로 나눈 몫을 저장
			now += arr[i] / mid;
		}

		// 현재 mid로 나눈 값이 N보다 크거나 같으면
		if ( now >= N )
		{
			// left를 움직여 길이가 더 긴 경우에도 가능한 지 검사
			left = mid + 1;		
			// N개를 만들 수 있을 때, 답을 더 큰 값으로 계속 갱신
			ans = max(ans, mid);
		}
		// 현재 mid로 나눈 값이 N보다 작을 경우
		else
		{
			// right를 움직여 길이가 더 짧은 경우에도 가능한 지 검사
			right = mid - 1;
		}
	}

	cout << ans << '\n';
}