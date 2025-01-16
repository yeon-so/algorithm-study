package beakjoon.자료구조.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;  

// 메모리 초과 원인
// 1. deque 를 LinkedList로 정의
//     -> ArrayDeque<>()로 변경
// 2. Pair을 public class 내 static class로 지정 시 메모리를 더 잡아먹는다.

class Pair {
    public int index;
    public int num;

    public Pair(int index, int num) {
        this.index = index;
        this.num = num;
    }  
}

public class Exam_2346 {
   public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    Deque<Pair> q = new ArrayDeque<>();

    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    int cnt = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    for(int i = 1; i <= cnt; i++) {
        Pair temp = new Pair(i, Integer.parseInt(st.nextToken()));
        q.addLast(temp);
    }

    br.close();

    Pair cur = q.remove();
    sb.append(cur.index).append(" ");
    int num = cur.num;

    while (!q.isEmpty()) {

        if(num > 0) {
            for(int i = 1; i < num; i++) {
                q.addLast(q.removeFirst());
            }
        } else {
            for(int i = num; i < 0; i++) {
                q.addFirst(q.removeLast());
            }
        }

        cur = q.remove();
        sb.append(cur.index).append(" ");
        num = cur.num;
    }

    System.out.println(sb);
    
   }
}
