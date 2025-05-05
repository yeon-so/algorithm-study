public class GenomicRangeQuery {
    // O(N * M) - 시간 초과 
    public int[] solution1(String S, int[] P, int[] Q) {
        char start = 'T';
        int[] result = new int[P.length];

        for(int i = 0; i < P.length; i++) {
            int a = P[i];
            int b = Q[i];

            for(int j = a; j <= b; j++) {

                if(start > S.charAt(j)){
                    start = S.charAt(j);
                }
                
            }

            switch(start){
                case 'A':
                result[i] = 1;
                break;
                case 'C':
                result[i] = 2;
                break;
                case 'G':
                result[i] = 3;
                break;
                case 'T':
                result[i] = 4;
                break;
            }

            start = 'T';
        }

        return result;

    }

    // O(N + M) - 누적합 사용
    public int[] solution2(String S, int[] P, int[] Q) {
        int[][] dnaPrefixNum = new int[3][S.length()+1]; 
        int[] result = new int[P.length];

        for(int i = 0; i < S.length(); i++) {
            char tempChar = S.charAt(i);

            for (int j = 0; j < 3; j++) {
                dnaPrefixNum[j][i + 1] = dnaPrefixNum[j][i]; 
            }

            if (tempChar == 'A') {
                dnaPrefixNum[0][i + 1]++;
            } else if (tempChar == 'C') {
                dnaPrefixNum[1][i + 1]++;
            } else if (tempChar == 'G') {
                dnaPrefixNum[2][i + 1]++;
            }
        }

        for(int i = 0; i < P.length; i++) {
            int from = P[i];
            int to = Q[i] + 1;

            if (dnaPrefixNum[0][to] - dnaPrefixNum[0][from] > 0)
                result[i] = 1;
            else if (dnaPrefixNum[1][to] - dnaPrefixNum[1][from] > 0)
                result[i] = 2;
            else if (dnaPrefixNum[2][to] - dnaPrefixNum[2][from] > 0)
                result[i] = 3;
            else
                result[i] = 4;
        }

        return result;

    }
}
