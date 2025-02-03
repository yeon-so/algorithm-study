package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exam_1351 {

    static Map<Long, Long> map = new HashMap<>();
    static int p, q;

    static long func(long n) {
        if(n == 0) return 1;
        if(map.containsKey(n)) return map.get(n);

        map.put(n,func(n/p) + func(n/q));

        return map.get(n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        System.out.println(func(n));
    }
}
