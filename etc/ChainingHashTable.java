import java.util.Arrays;

public class ChainingHashTable {

    static final int M = 1000003; // 테이블 크기
    static final int a = 1000; // 해시 함수에서 사용할 곱의 값
    static final int MX = 500005; // 최대 
    static int[] head = new int[M]; // 각 해시 버킷의 첫 번째 요소
    static int[] pre = new int[MX]; // 연결리스트의 이전
    static int[] nxt = new int[MX]; // 연결리스트의 이후
    static String[] key = new String[MX]; // 삽입된 키를 저장하는 배열
    static int[] val = new int[MX]; // 삽입된 값
    static int unused = 0; // 새 원소를 추가할 때 사용할 인덱스 

    // 해시 함수 (롤링 해시)
    static int myHash(String s) {
        int h = 0;
        for(char c : s.toCharArray()) { 
            h = (h * a + c) % M;
        }
        return h;
    }

    // key[idx] == k인 idx 반환
    // 만일 k가 존재하지 않을 경우 -1을 반환
    // 키에 대응되는 값을 반환하는 게 아니라 인덱스를 반환하는 것에 주의
    static int find(String k) {
        int hash = myHash(k);
        int idx = head[hash];

        while (idx != -1) {
            if(key[idx].equals(k)) { // 연결리스트 탐색
                return idx; // 키가 일치하면 해당 인덱스 반환
            }
            idx = nxt[idx];
        }
        return -1; // 키가 없으면 -1 반환
    }

    static void insert(String k, int v) {
        int idx = find(k);
        if(idx != -1) { // 이미 존재하는 키가 있을 경우엔 값만 업데이트
            val[idx] = v;
            return;
        }
        int hash = myHash(k);
        key[unused] = k; // 새로운 키 저장
        val[unused] = v; // 새로운 값 저장
        if(head[hash] != -1) { // 연결리스트가 비어있지 않을 경우
            nxt[unused] = head[hash];
            pre[head[hash]] = unused;
        }
        head[hash] = unused; // 새로운 요소를 해시 버킷의 시작으로 설정
        unused++; // 다음 사용 가능한 인덱스로 증가
    }

    static void erase(String k) {
        int idx = find(k);
        if (idx == -1) return; // 존재하는 키가 없을 경우 바로 종료

        if (pre[idx] != -1) { // 이전 요소가 있을 경우
            nxt[pre[idx]] = nxt[idx]; 
        } 
        if (nxt[idx] != -1) { // 다음 요소가 있을 경우
            pre[nxt[idx]] = pre[idx];
        }
        int hash = myHash(k);
        if(head[hash] == idx) head[hash] = nxt[idx]; // 해시 버킷의 첫 요소를 갱신
    }

    static void test() {
        insert("orange", 724);
        insert("melon", 20);
        if (val[find("melon")] != 20) {
            System.out.println("Test failed: Expected value for 'melon' is 20, but got " + val[find("melon")]);
            return;
        }
        insert("banana", 52);
        insert("cherry", 27);
        insert("orange", 100);
        if (val[find("banana")] != 52) {
            System.out.println("Test failed: Expected value for 'banana' is 52, but got " + val[find("banana")]);
            return;
        }
        if (val[find("orange")] != 100) {
            System.out.println("Test failed: Expected value for 'orange' is 100, but got " + val[find("orange")]);
            return;
        }
        erase("wrong_fruit");
        erase("orange");
        if (find("orange") != -1) {
            System.out.println("Test failed: Expected 'orange' to be erased, but it still exists.");
            return;
        }
        erase("orange");
        insert("orange", 15);
        if (val[find("orange")] != 15) {
            System.out.println("Test failed: Expected value for 'orange' is 15, but got " + val[find("orange")]);
            return;
        }
        insert("apple", 36);
        insert("lemon", 6);
        insert("orange", 701);
        if (val[find("cherry")] != 27) {
            System.out.println("Test failed: Expected value for 'cherry' is 27, but got " + val[find("cherry")]);
            return;
        }
        erase("xxxxxxx");
        if (find("xxxxxxx") != -1) {
            System.out.println("Test failed: Expected 'xxxxxxx' to not exist, but it does.");
            return;
        }
        if (val[find("apple")] != 36) {
            System.out.println("Test failed: Expected value for 'apple' is 36, but got " + val[find("apple")]);
            return;
        }
        if (val[find("melon")] != 20) {
            System.out.println("Test failed: Expected value for 'melon' is 20, but got " + val[find("melon")]);
            return;
        }
        if (val[find("banana")] != 52) {
            System.out.println("Test failed: Expected value for 'banana' is 52, but got " + val[find("banana")]);
            return;
        }
        if (val[find("cherry")] != 27) {
            System.out.println("Test failed: Expected value for 'cherry' is 27, but got " + val[find("cherry")]);
            return;
        }
        if (val[find("orange")] != 701) {
            System.out.println("Test failed: Expected value for 'orange' is 701, but got " + val[find("orange")]);
            return;
        }
        if (val[find("lemon")] != 6) {
            System.out.println("Test failed: Expected value for 'lemon' is 6, but got " + val[find("lemon")]);
            return;
        }
    
        System.out.println("All tests passed!");
    }
    

    public static void main(String[] args) {
        Arrays.fill(head, -1);
        Arrays.fill(pre, -1);
        Arrays.fill(nxt, -1);
        test();
    }
}
