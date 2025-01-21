package beakjoon.정렬.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exam_1432 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> arr = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String temp = br.readLine();
            arr.add(temp);
        }

        arr.sort((o1, o2) -> {
            // 길이 비교 (짧은 것부터) - 음수면 o1이 앞, 양수면 o2가 뒤, 0이면 그대로
            if(o1.length() != o2.length()) {
                return o1.length() - o2.length();
            } else {
                int num1 = 0;
                int num2 = 0;

                // 숫자 값만 더하기
                for(int i = 0; i < o1.length(); i++) {
                    int temp1 = o1.charAt(i) - '0';
                    int temp2 = o2.charAt(i) - '0';
                    if(temp1 >= 0 && temp1 <= 9) {
                        num1 += temp1;
                    }
                    if(temp2 >= 0 && temp2 <= 9) {
                        num2 += temp2;
                    }
                }

                // 숫자 비교 (수가 작은 것부터)
                if( num1 != num2 ) {
                    return num1 - num2;
                // 숫자가 같다면 사전 순
                } else{
                    return o1.compareTo(o2);
                }
            }
        });

        for(String e : arr) {
            System.out.println(e);
        }

    }
}
