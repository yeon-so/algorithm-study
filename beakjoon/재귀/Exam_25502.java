package beakjoon.재귀;

import java.io.*;

public class Exam_25502 {

    static int recCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            String str = br.readLine();
            recCnt = 0;
            int result = isPalindrome(str);
            System.out.println(result + " " + recCnt);
        }
    }

    public static int isPalindrome(String str) {
        return recursion(str, 0, str.length() - 1);
    }

    public static int recursion(String str, int l, int r) {
        recCnt++;
        if(l >= r) return 1;
        else if(str.charAt(l) != str.charAt(r)) return 0;
        else return recursion(str, l+1, r-1);
    }
}
