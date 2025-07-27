package programmers.2018-KAKAO-BLIND;

import java.util.*;

public class 뉴스_클러스터링 {

    // O(n * m)
    public int solution1(String str1, String str2) {
        
        double answer = 0;
        
        List<String> list1 = toStringList(str1);
        List<String> list2 = toStringList(str2);
        
        // 합집합
        List<String> union = new ArrayList<>();
        // 교집합
        List<String> inter = new ArrayList<>();
        
        for(int i = 0; i < list1.size(); i++) { // O(n)
            String temp = list1.get(i);
            
            if(list2.remove(temp)){ // O(M)
                inter.add(temp);
            }
            
            union.add(temp);
        }
        
        union.addAll(list2);
        
        
        if(inter.isEmpty() && union.isEmpty()) {
            return 65536;
        }
        
        // 형변환 주의
        answer = ((double)inter.size() / (double)union.size()) * 65536;
        
        return (int) answer;
        
    }
    
    public List<String> toStringList(String str){
        
        List<String> list = new ArrayList<>();
        
        str = str.toUpperCase();
        
        for(int i = 0; i < str.length() - 1; i++) {
            char first = str.charAt(i);
            char second = str.charAt(i+1);
            
            if(first >= 'A' && first <= 'Z' &&
               second >= 'A' && second <= 'Z') {
                list.add(first + "" + second);
            }
        }
        
        return list;
        
    }

    // O(n + m)
    public int solution2(String str1, String str2) {
        
        Map<String,Integer> map1 = toMap(str1);
        Map<String,Integer> map2 = toMap(str2);
        
        int inter = 0;
        int union = 0;
        
        Set<String> set = new HashSet<>();
        set.addAll(map1.keySet());
        set.addAll(map2.keySet());
        
        for(String str : set) { // O(n + m)
            int a = map1.getOrDefault(str, 0);
            int b = map2.getOrDefault(str, 0);
            
            inter += Math.min(a, b);
            union += Math.max(a, b);
        }
        
        if(union == 0 ) {
            return 65536;
        }
    
        
        double answer = (double) inter / (double) union;
        
        return (int)(answer * 65536);
    }
    
    public Map<String,Integer> toMap(String str) {
        Map<String,Integer> map = new HashMap<>();
        
        str = str.toUpperCase();
        
        for(int i = 0; i < str.length() - 1; i++) {
            char first = str.charAt(i);
            char second = str.charAt(i + 1);
            
            if(first >= 'A' && first <= 'Z' &&
               second >= 'A' && second <= 'Z') {
                String ans = first + "" + second;
                map.put(ans, map.getOrDefault(ans, 0) + 1);
            }
        }
        
        return map;
    }
}
