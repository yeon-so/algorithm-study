import java.util.Arrays;

public class OpenAddressingHashTable {
    static final int M = 1000003; // 테이블 크기
    static final int a = 1000; // 해시 함수에서 사용할 곱의 값
    static final int EMPTY = -1;
    static final int OCCUPY = 0;
    static final int DUMMY = 1;
    static int[] status = new int[M]; // EMPTY / OCCUPY / DUMMY
    static String[] key = new String[M];
    static int[] val = new int[M];

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
        int idx = myHash(k);
        while (status[idx] != EMPTY) { // 다음 버킷이 Empty가 아닐닐 때 까지 탐색
            if(status[idx] == OCCUPY && key[idx] == k){ // 해당 버킷에 값이 있고, 키값이 k와 같다면 해당 idx 반환
                return idx;
            }
            idx = (idx+1) % M; // 다음 버킷 조회
        }
        // k가 없으면 -1 반환
        return -1;
    }

    static void insert(String k, int v) {
        int idx = find(k);
        if(idx != -1) { // 대응되는 키가 있다면
            val[idx] = v; // 해당 인덱스 값만 업데이트
            return;
        }
        idx = myHash(k);
        while (status[idx] == OCCUPY) { // 이미 값이 있으면 통과
            idx = (idx+1) % M;
        }
        key[idx] = k; // 새로운 키 저장
        val[idx] = v; // 새로운 값 저장
        status[idx] = OCCUPY; // 해당 상태에 값이 있음을 표시
    }

    static void erase(String k) {
        int idx = find(k);
        if(idx == -1) { // 대응되는 키가 없다면 바로 종료
            return;
        } else { // 대응되는 키가 있다면
            status[idx] = DUMMY; // 더미로 변경
        }
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
        Arrays.fill(status, EMPTY);
        test();
    }
}
