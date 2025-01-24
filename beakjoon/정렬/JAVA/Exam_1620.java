package beakjoon.정렬.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Exam_1620 {

    static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void main(String[] args) throws IOException {
        HashMap<Integer, String> map = new HashMap<>();
        HashMap<String, Integer> reversMap = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++) {
            String name = br.readLine();
            map.put(i, name);
            reversMap.put(name, i);
        }

        for(int i = 0; i < m; i++) {
            String str = br.readLine();
            
            if(isNumber(str)){
                int num = Integer.parseInt(str);
                System.out.println(map.get(num));
            } else {
                System.out.println(reversMap.get(str));
            }

        }

    }
}
