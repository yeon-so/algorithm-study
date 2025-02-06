package beakjoon.정렬.JAVA;

/*
 * HashMap 사용 
 */

import java.util.*;
import java.io.*;

public class Exam_10816_1 {

    static int N;
    static int M;
    static HashMap<Integer,Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            int tCnt = 1;

            if(map.containsKey(temp)){
                tCnt = map.get(temp) + 1;
            }

            map.put(temp, tCnt);
        }

        M = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            int temp = Integer.parseInt(st.nextToken());
            int result;
            if(map.get(temp) != null){
                result = map.get(temp);
            } else {
                result = 0;
            }
            sb.append(result).append(" ");
            
        }

        System.out.println(sb.toString());
    }
}
