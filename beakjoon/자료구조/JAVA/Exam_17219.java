package beakjoon.자료구조.JAVA;

import java.util.*;
import java.io.*;

public class Exam_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String url = st.nextToken();
            String pw = st.nextToken();

            map.put(url, pw);
        }

        for(int i = 0; i < m; i++) {
            String temp = br.readLine();
            System.out.println(map.get(temp));
        }

    }
}
