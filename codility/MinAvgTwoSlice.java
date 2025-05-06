public class MinAvgTwoSlice {
    // O(N) - float
    public int solution1(int[] A) {
        int minPos = 0;
        float minAvg = Integer.MAX_VALUE;
        int length = A.length - 2;

        for(int i = 0; i < length; i++) {
            float avg1 = (float)(A[i] + A[i+1])/2;
            float avg2 = (float)(A[i] + A[i+1] + A[i+2])/3;

            float curAvg = Math.min(avg1,avg2);

            if(curAvg < minAvg) {
                minAvg = curAvg;
                minPos = i;
            }
            
        }

        float lastAvg = (float)(A[length] + A[length+1]) / 2;
        if(lastAvg < minAvg){
            minPos = length;
        }

        return minPos;
    }

    // O(N) - double
    public int solution2(int[] A) {
        int minPos = 0;
        double minAvg = Double.MAX_VALUE;
        int length = A.length - 2;

        for(int i = 0; i < length; i++) {
            double avg1 = (A[i] + A[i+1])/2.0;
            double avg2 = (A[i] + A[i+1] + A[i+2])/3.0;

            double curAvg = Math.min(avg1,avg2);

            if(curAvg < minAvg) {
                minAvg = curAvg;
                minPos = i;
            }
            
        }

        double lastAvg = (A[length] + A[length+1]) / 2.0;
        if(lastAvg < minAvg){
            minPos = length;
        }

        return minPos;
    }

    // O(N^2) - 시간초과
    // 길이 2 또는 3짜리 슬라이스만 비교해도 된다는 수학적 증명이 있어 3까지만 처리해도 된다.
    // 여기선 누적합으로 모든 길이의 슬라이스를 구해서 시간 초과
    public int solution3(int[] A) {
        int length = A.length;
        double minAvg = Double.MAX_VALUE;
        int minPos = 0;

        // 누적합
        int[] prefixSum = new int[length + 1];
        for(int i = 0; i < length; i++) {
            prefixSum[i + 1] = prefixSum[i] + A[i];
        }

        for(int i = 0; i < length; i++) {
            for(int j = i + 1; j < length; j++) {
                double avg = (double)(prefixSum[j+1] = prefixSum[i])/(j - i + 1);
                if(avg < minAvg) {
                    minAvg = avg;
                    minPos = i;
                }
            }
        }

        return minPos;
    }
}
