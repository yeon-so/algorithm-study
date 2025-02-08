package programmers.해시;

import java.util.Arrays;
import java.util.HashMap;

public class 완주하지_못한_선수 {

    // Array 이용
    public String solution1(String[] participant, String[] completion) { 
    
        Arrays.sort(participant);
        Arrays.sort(completion);

        int leng = completion.length;
        for(int i = 0; i < leng; i++) {
            if (!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        
        return participant[leng];

    }

    // Hash 이용
    public String solution2(String[] participant, String[] completion) { 
    
        HashMap<String,Integer> map = new HashMap<>();
        String result = "";
        
        for(String str : participant) {
            if(map.containsKey(str)){
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
            
        }
        
        for(String str : completion) {
            if(map.containsKey(str)){
                if(map.get(str) > 1){
                    map.put(str, map.get(str) - 1);     
                } else {
                    map.remove(str);
                }   
            }
        }
        
        for(String str: map.keySet()) {
            result += str;
        }
        
        return result;
    }
}
