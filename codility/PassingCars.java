public class PassingCars {

    // O(N) - 누적합
    public int solution(int[] A) {
        
        // int 자료형 오버플로우가 발생할 수 있어서 변경
        long eastNum = 0;
        long passingNum = 0;

        for(int i = 0; i < A.length; i++) {
            if(A[i] == 0) {
                eastNum++;
            }

            if(A[i] == 1) {
                passingNum = passingNum + eastNum;
            }
        }

        if(passingNum > 1_000_000_000) {
            return -1;
        }

        return (int) passingNum;

    }
}
