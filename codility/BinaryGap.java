package codility;

class Solution {
    // toBinaryString 사용 (왼->오) O(logN)
    public int solution1(int N) {
        
        String str = Integer.toBinaryString(N);
        int tempGap = 0;
        int maxGap = 0;

        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == '0') {
                tempGap++;
            } else {
                maxGap = Math.max(maxGap, tempGap);
                tempGap = 0;
            }
        }
        
        return maxGap;
    }

    // 비트 연산 사용 (오->왼) O(logN)
    public int solution2(int N) {
    
        int tempGap = 0;
        int maxGap = 0;
        boolean counting = false;

        while(N != 0) {
            if(!counting) {
                if((N & 1) == 1) { // 마지막 비트가 1인지 확인
                    counting = true; 
                } 
            } else {
                if((N & 1) == 0) {
                    tempGap++;
                } else {
                    maxGap = Math.max(maxGap, tempGap);
                    tempGap = 0; // 초기화
                }
            }

            N = N >> 1; // 오른쪽으로 1비트 이동
        }
        
        return maxGap;
    }
}
