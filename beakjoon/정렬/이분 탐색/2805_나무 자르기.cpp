#include<iostream>
#include<algorithm>

using namespace std;

// 각각의 나무 길이
long long H[1000001] = {0,};

int main()
{
	// 나무의 수 N, 집으록 가져가려는 나무의 길이 M, 결과 ans
	long long N, M, ans;
	ans = 0;

	cin >> N >> M;

	// 나무 중 가장 긴 나무의 길이
	long long maxi = 0;

	for(int i = 0; i < N; i++)
	{
		cin >> H[i];

		maxi = max(maxi, H[i]);
	}

	long long left = 1;
	long long right = maxi;
	long long mid;

    // 이진 탐색
	while(left <= right)
	{
		mid = (left + right) / 2;

		// 들고갈 수 있는 나무 길이
		long long now = 0;

		for(int i = 0; i < N; i++)
		{
			// 절단기 높이보다 나무가 길 경우에만 
			if(H[i] > mid)
				now += H[i] - mid;
		}

		// 들고가야할 나무 길이(M)보다 들고 갈 수 있는 나무가 더 길 경우
		if(now >= M)
		{
			// 절단기를 더 높여도 된다.
			left = mid + 1;
			// 절단기 최대 높이 갱신, max(mid,ans)와 같다.
			if(ans < mid)
			{
				ans = mid; 
			}

		}
		// 들고가야할 나무 길이(M)보다 들고 갈 수 있는 나무가 더 적을 경우
		else
		{
			// 절단기를 더 낮춰야 한다.
			right = mid - 1;
		}
	}

	cout << ans << '\n';

}