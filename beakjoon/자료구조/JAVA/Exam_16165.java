package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Exam_16165 {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> nameMap = new HashMap<>();
        HashMap<String, List<String>> groupMap = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n; i++) {
            List<String> list = new ArrayList<>();
            String groupName = br.readLine();
            int count = Integer.parseInt(br.readLine());
            for(int j = 0; j < count; j++) {
                String memName = br.readLine();
                nameMap.put(memName, groupName);
                list.add(memName);
            }
            groupMap.put(groupName, list);
        }

        for(int i = 0; i < m; i++) {
            String question = br.readLine();
            int type = Integer.parseInt(br.readLine());
            if(type == 1) {
                System.out.println(nameMap.get(question));
            } else { 
                List<String> answer = groupMap.get(question);
                Collections.sort(answer);
                for(String str : answer) {
                    System.out.println(str);
                }
            }
        }

    }
}
