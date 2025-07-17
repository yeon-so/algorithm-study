package beakjoon.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam_1629 {

    public static long pow(long a, long b, long c) {
        if(b == 1) return a%c;
        long val = pow(a, b/2, c);
        val = val * val % c;
        if(b%2 == 0) return val;
        return val * a % c; 
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println(pow(a,b,c));

    }
}
