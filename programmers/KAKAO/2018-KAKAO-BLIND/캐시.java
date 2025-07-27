package programmers.2018-KAKAO-BLIND;

import java.util.*;

public class 캐시 {

    // Set, Duque 사용 
    public int solution1(int cacheSize, String[] cities) {
        int answer = 0;
        int L = cities.length;
        
        if(cacheSize == 0) {
            return L * 5;
        }

        Set<String> cacheSet = new HashSet<>();
        Deque<String> cache = new LinkedList<>();
        
        for(int i = 0; i < L; i++) {
            
            // 대소문자 구분 안함
            String city = cities[i].toUpperCase();            
            
            if(cacheSet.contains(city)){ // O(1)
                // hit
                cache.remove(city); // O(n)
                cache.addFirst(city);
                answer += 1;
            } else {
                // miss
                if(cache.size() == cacheSize) {
                    String removed = cache.removeLast();
                    cacheSet.remove(removed); // O(1)
                }
                cache.addFirst(city);
                cacheSet.add(city);
                answer += 5;
            }
        }
         
        return answer;
    }

    // List 사용
    public int solution2(int cacheSize, String[] cities) {
        int answer = 0;
        int L = cities.length;
        
        if(cacheSize == 0) {
            return L * 5;
        }

        List<String> cacheList = new ArrayList<>();
        
        for(int i = 0; i < L; i++) {
            
            // 대소문자 구분 안함
            String city = cities[i].toUpperCase();            
            
            if(cacheList.contains(city)){ // O(n)
                // hit
                cacheList.remove(city); // O(n)
                cacheList.add(city);
                answer += 1;
            } else {
                // miss
                if(cacheList.size() == cacheSize) {
                    cacheList.remove(0); // O(n)
                }
                cacheList.add(city);
                answer += 5;
            }
        }
         
        return answer;
    }

    // LinkedListHashMap 사용 O(1)
    public class LRU<K,V> extends LinkedHashMap<K,V> {
        private final int capacity;
        
        public LRU(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }
        
        @Override
        protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
            return size() > capacity;
        }
    }
    
    public int solution3(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0) {
            return cities.length * 5;
        }

        LRU<String, String> cache = new LRU<>(cacheSize);
        
        for(int i = 0; i < cities.length; i++){
            String city = cities[i].toUpperCase();
            
            if(cache.containsKey(city)){
                answer += 1;
            } else {
                answer += 5;
            }
            
            cache.put(city,city);
        }
        
        return answer;
    }
}
