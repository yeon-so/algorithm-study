package beakjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class 알람시계_2884 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int H = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);

        if( M >= 45 ) {
            M -= 45;
        } else {
            if( H > 0 ){
                H -= 1;
            } else {
                H = 23;
            }

            M += 15;
        }

        System.out.println(H + " " + M);
    }
}