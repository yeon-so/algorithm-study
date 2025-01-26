package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Exam_19583 {
    public static void main(String[] args) throws IOException {
        // 00:00 ~ 23:59
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, String> map = new HashMap<>();
        String s = st.nextToken(); // 개강총회를 시작한 시간
        String e = st.nextToken(); // 개강총회를 끝낸 시간
        String q = st.nextToken(); // 스트리밍을 끝낸 시간

        String tmp = null;
        int result = 0;
        while((tmp = br.readLine()) != null) {

            String time = tmp.substring(0,5);
            String writer = tmp.substring(6);

            if(time.compareTo(s) < 1) {
                map.put(writer, writer);
            } 

            if(time.compareTo(e) >= 0 && time.compareTo(q) < 1) {
                if(map.containsKey(writer)){
                    result++;
                    map.remove(writer);
                }
            }
            
        }

        System.out.println(result);

    }
}
