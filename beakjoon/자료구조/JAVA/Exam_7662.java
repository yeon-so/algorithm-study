package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exam_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();
            for(int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if(op.equals("I")){ // 삽입
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else {    // 삭제
                    if(map.size() == 0) continue;
                    int num = n == 1 ? map.lastKey() : map.firstKey();  // 1이면 최댓값, -1이면 최솟값
                    if(map.put(num, map.get(num) - 1) == 1) { // 남은 값이 1개라면 해당 값을 삭제
                        map.remove(num);
                    }
                    /* 위의 if랑 같은 거
                      if (map.get(num) != 1) { 
                         map.put(num, map.get(num) - 1);
                      } else { 
                         map.remove(num);
                      }
                     */
                }
            }

            System.out.println(map.size() == 0 ? "EMPTY" : map.lastKey() + " " + map.firstKey());
        }
    }
}
