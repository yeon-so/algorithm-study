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
}
