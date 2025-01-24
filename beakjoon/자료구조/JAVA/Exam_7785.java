package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Exam_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        HashMap<String, String> map = new HashMap<>();
        

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String k = st.nextToken();
            String v = st.nextToken();

            if(v.equals("enter")) {
                map.put(k, v);
            } else {
                map.remove(k);
            }
        }

        br.close();

        List<String> keList = new ArrayList<>(map.keySet());
        Collections.sort(keList, Collections.reverseOrder());

        for(String e: keList) {
            System.out.println(e);
        }
    }
}
