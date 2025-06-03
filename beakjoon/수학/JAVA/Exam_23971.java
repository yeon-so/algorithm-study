package beakjoon.수학.JAVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Exam_23971 {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int H = Integer.parseInt(temp[0]);
        int W = Integer.parseInt(temp[1]);
        int N = Integer.parseInt(temp[2]);
        int M = Integer.parseInt(temp[3]);

        int height = (H - 1) / (N + 1) + 1;
        int width = (W - 1) / (M + 1) + 1;

        System.out.print(width * height);
    }
}