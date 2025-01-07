package beakjoon.백트래킹.JAVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// L개의 알파벳 소문자.
// 최소 한 개의 모음 a e i o u / 최소 두개의 모음
// 정렬된 문자열 abc (o) bac (x)
// c개의 문자열

public class Exam_1759 {
    static int L;
    static int C;
    static String[] nums;
    static String[] result;
    static boolean[] isUsed;
    static String[] vowel = new String[]{"a", "e", "i", "o", "u"};
    static StringBuilder sb = new StringBuilder();

    static void func(int st, int cur) {
        if(cur == L) {

            if(!isValid()){
                return;
            }

            for(int i = 0; i < L; i++) {
                sb.append(result[i]);
            }
            sb.append("\n");
            return;
        }

        for(int i = st; i < C; i++) {
            if(!isUsed[i]){
                isUsed[i] = true;
                result[cur] = nums[i];
                func(i, cur+1);
                isUsed[i] = false;

            }
        }
    }

    static boolean isValid(){

        int conN = 0;
        int voN = 0;

        for(int i = 0; i < L; i++) {
            for(String str: vowel){
                if(result[i].equals(str)){
                    voN++;
                }
            }
        }

        conN = L - voN;

        if(voN >= 1 && conN >= 2) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        nums = new String[C];
        result = new String[L];
        isUsed = new boolean[C];

        String[] temp = br.readLine().split(" ");

        for(int i = 0; i < C; i++) {
            nums[i] = temp[i];
        }

        Arrays.sort(nums);

        func(0,0);

        System.out.println(sb);
    }
}
