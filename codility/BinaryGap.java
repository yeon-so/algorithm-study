package codility;

class Solution {
    public int solution(int N) {
        
        String str = Integer.toBinaryString(N);
        int temp = 0;
        int answer = 0;

        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == '0') {
                temp++;
            } else {
                answer = Math.max(answer, temp);
                temp = 0;
            }
        }
        
        return answer;
    }
}
