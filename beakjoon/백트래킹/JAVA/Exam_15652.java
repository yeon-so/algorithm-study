import java.util.*;
import java.io.*;

public class Exam_15652 {
    static int N;
    static int M;
    static int a[] = new int[10];
    static StringBuilder sb = new StringBuilder();

    static void func(int cur){
        if(cur == M) {
            for(int i = 0; i < M; i++){
                sb.append(a[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            if( cur == 0 ){
                a[cur] = i;
                func(cur + 1);
            } else if( cur > 0 && a[cur -1] <= i){
                a[cur] = i;
                func(cur + 1);  
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        func(0);

        System.out.println(sb);
    }
}
