package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Exam_13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new LinkedHashMap<>();

        for(int i = 0; i < l; i++) {
            String temp = br.readLine();

            if(map.containsKey(temp)){
                map.remove(temp);
            }
            map.put(temp, temp);
        }

        List<String> list = new ArrayList<>(map.keySet());

        int end = k > list.size() ? list.size() : k;
        for(int i = 0; i < end; i++) {
            System.out.println(list.get(i));
        }

    }
}
