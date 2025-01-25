package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Exam_9375 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());


        // 테스트 케이스 반복
        for(int i = 0; i < t; i++) {
            int result = 1;
            HashMap<String, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());

            // n 개의 입력값
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine()); 
                String name = st.nextToken();
                String type = st.nextToken();

                // 같은 타입이 없다면 새로 등록, 이미 있다면 갯수만 +1
                if(!map.containsKey(type)){
                    map.put(type, 1);
                } else {
                    int cnt = map.get(type);
                    map.put(type, cnt+1);
                }
            }

            // 모든 조합 구하기 
            // headgear = [ hat, turban, 아무것도 입지 않음 ]
            // eyewear = [ sunglasses, 아무것도 입지 않음 ]
            // 각각의 경우의 수룰 구한 후 곱하면 된다.
                // 3C1 * 2C1 = 3 * 2 = 6  
            for(int val : map.values()) {
                result *= (val + 1);
            }

            // 여기서 headgear eyewrear 모두 입지 않은 경우를 제거
            System.out.println(result - 1);
        }
    }
}


