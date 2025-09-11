package programmers.프로그래머스_코드챌린지.2025;

import java.util.*;

public class 비밀 코드 해독 {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        
        ArrayList<Integer> numbers = new ArrayList<>();
        
        for(int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        // 1. 비밀 코드 조합 만들기
        // numbers : 1~n까지 서로다른 정수 리스트, r : 비밀코드 갯수, start: 시작점, temp : 임시 조합리스트, depth: 현재 temp를 채운 위치, result : 최종 조합리스트
        ArrayList<int[]> codeList = new ArrayList<>();
        int length = ans.length;
        
        dfs(numbers, 5, 0, new int[5], 0, codeList);
        
        // 2. 가능한 비밀 코드 구하기
        for(int[] code : codeList) {
            boolean isValid = true;
            for(int i = 0; i < q.length; i++) {
                if(ans[i] != func(q[i], code)){
                    isValid = false;
                    break;
                }
            }
            if(isValid) {
                answer++;
            }
        }
        
        return answer;
    }
    
    static void dfs(List<Integer> numbers, int r, int start, int[] temp, int depth, List<int[]> result) {
        if (depth == r) {
            result.add(temp.clone());
            return;
        }
        
        for(int i = start; i < numbers.size(); i++) {
            temp[depth] = numbers.get(i);
            dfs(numbers, r, i + 1, temp, depth + 1, result);
        }
    } 
        
    static int func(int[] a, int[] b) {
        int cnt = 0;
        for(int aa : a) {
            for(int bb : b) {
                if(aa == bb) {
                    cnt++;
                }
            }
        }
        
        return cnt;
    }    
}
